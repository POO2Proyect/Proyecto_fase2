/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import utils.JsfUtil;
import entidades.ClientesEntity;
import java.util.List;
import utils.JpaUtil;
import entidades.UsuariosEntity;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import modelo.ClientesModel;
import modelo.UsuariosModel;
/**
 *
 * @author Nestor2
 */
@ManagedBean
@RequestScoped
public class UsuariosBean {
    
    UsuariosModel modelo = new UsuariosModel();
    private UsuariosEntity usuario;
    private List<UsuariosEntity> listaUsuarios;
    
   public List<UsuariosEntity> getListaUsuarios(){
        return modelo.listarUsuarios();
    }
    private List<SelectItem> listaClientes;

    public List<SelectItem> getListaClientes() {
        this.listaClientes = new ArrayList<SelectItem>();
       ClientesModel model = new ClientesModel();
       List<ClientesEntity> c = model.listarClientes();
       
       
       for (ClientesEntity clientes : c){
           SelectItem ClienteItem = new SelectItem(clientes.getIdClientes(),clientes.getNombre());
           this.listaClientes.add(ClienteItem);
       }
        return listaClientes;    
    }

    public void setListaClientes(List<SelectItem> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    public UsuariosEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariosEntity usuario) {
        this.usuario = usuario;
    }

    /**
     * Creates a new instance of Usuarios
     */
    public UsuariosBean() {
        usuario = new UsuariosEntity();
    }
    
     public String guardarUsuario() {
        if (modelo.insertarUsuario(usuario) != 1) {
            
            return "registroUsuarios?faces-redirect=true";
        } else {
            JsfUtil.setFlashMessage("exito", "Usuario registrado exitosamente");
            //Forzando la redirección en el usuario
            return "registroUsuarios?faces-redirect=true";
        }
    }
     
     public String eliminarUsuario() {
// Leyendo el parametro enviado desde la vista
        String idUsuario = JsfUtil.getRequest().getParameter("idUsuario");
        if (modelo.eliminarUsuarios(idUsuario) > 0) {
            JsfUtil.setFlashMessage("exito", "Usuario eliminado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "");
        }
        return "registroUsuarios?faces-redirect=true";
    }
     
     public String modificarUsuarios() {
        if (modelo.modificarUsuarios(usuario) > 0) {
            JsfUtil.setFlashMessage("exito", "Usuario modificado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "");
        }
        return "registroUsuarios?faces-redirect=true";
    
    }
     
     public void obtenerUsuarios() {
        String idUsuarios = JsfUtil.getRequest().getParameter("idUsuario");
        usuario= modelo.obtenerUsuario(idUsuarios);
    }
        
    
}

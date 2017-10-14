/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.sun.xml.internal.ws.client.RequestContext;
import entidades.EmpleadoEntity;
import entidades.PerfilempleadosEntity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import entidades.UsuariosempleadosEntity;
import java.util.ArrayList;
import modelo.UsuariosEmpleadosModel;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import modelo.EmpleadosModel;
import modelo.PerfilesModel;
import utils.JpaUtil;
import utils.JsfUtil;


/**
 *
 * @author Usuario
 */
@ManagedBean
@RequestScoped
public class UsuariosEmpleadosBean {

    public UsuariosEmpleadosModel getModelo() {
        return modelo;
    }

    public void setModelo(UsuariosEmpleadosModel modelo) {
        this.modelo = modelo;
    }

    public String getPasswordEmp() {
        return passwordEmp;
    }

    public void setPasswordEmp(String passwordEmp) {
        this.passwordEmp = passwordEmp;
    }

    public String getUsuarioEmp() {
        return usuarioEmp;
    }

    public void setUsuarioEmp(String usuarioEmp) {
        this.usuarioEmp = usuarioEmp;
    }
    
    
    private UsuariosempleadosEntity usuEmpleados;
   private List<UsuariosempleadosEntity> listausuEmpleados;
    UsuariosEmpleadosModel modelo = new UsuariosEmpleadosModel();
    private String passwordEmp;
    private String usuarioEmp;

     public List<UsuariosempleadosEntity> getListUusuEmpleados(){
        return modelo.listarusuEmpleados();
    }
    public UsuariosempleadosEntity getUsuEmpleados() {
        return usuEmpleados;
    }

    public void setUsuEmpleados(UsuariosempleadosEntity usuEmpleados) {
        this.usuEmpleados = usuEmpleados;
    }
    /**
     * Creates a new instance of UsuariosEmpleadosBean
     */
    public UsuariosEmpleadosBean() {
        usuEmpleados = new UsuariosempleadosEntity();
    }
    
    private List<SelectItem> listaEmpleados;

    public List<SelectItem> getListaEmpleados() {
        this.listaEmpleados = new ArrayList<SelectItem>();
       EmpleadosModel model = new EmpleadosModel();
       List<EmpleadoEntity> c = model.listarEmpleados();
       
       
       for (EmpleadoEntity empleados : c){
           SelectItem EmpleadosItem = new SelectItem(empleados.getIdEmpleado(),empleados.getNombre());
           this.listaEmpleados.add(EmpleadosItem);
       }
        return listaEmpleados;    
    }
    
      public void setListaEmpleados(List<SelectItem> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
      
      
      
       private List<SelectItem> listaPerfil;

    public List<SelectItem> getListaPerfil() {
        this.listaPerfil = new ArrayList<SelectItem>();
      PerfilesModel model = new PerfilesModel();
       List<PerfilempleadosEntity> c = model.listarPerfil();
       
       
       for (PerfilempleadosEntity perfil : c){
           SelectItem PerfilItem = new SelectItem(perfil.getIdPerfilEmpleados(),perfil.getPerfil());
           this.listaPerfil.add(PerfilItem);
       }
        return listaEmpleados;    
    }
    
      public void setListaPerfil(List<SelectItem> listaPerfil) {
        this.listaPerfil = listaPerfil;
    }
    /*fin de llenado.........*/
      public String guardarusuEmpleados() {
        if (modelo.insertarusuEmpleados(usuEmpleados) != 1) {
            modificarusuEmpleados();
            return "registroUsuariosEmpleados?faces-redirect=true";
        } else {
            JsfUtil.setFlashMessage("exito", "UsuarioEmpleado registrado exitosamente");
            //Forzando la redirección en el cliente
            return "registroUsuariosEmpleados?faces-redirect=true";
        }
    }
     
     public String eliminarusuEmpleados() {
// Leyendo el parametro enviado desde la vista
        String idUsuarioEmpleados = JsfUtil.getRequest().getParameter("idUsuarioEmpleados");
        if (modelo.eliminarusuEmpleados(idUsuarioEmpleados) > 0) {
            JsfUtil.setFlashMessage("exito", "UsuarioEmpleado eliminado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "No se pudo borrar este Usuario");
        }
        return "registroUsuariosEmpleados?faces-redirect=true";
    }
     
      public String modificarusuEmpleados() {
        if (modelo.modificarusuEmpleados(usuEmpleados) > 0) {
            JsfUtil.setFlashMessage("exito", "usuempleado modificado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "Nose pudo modificar el empleado");
        }
        return "registroUsuariosEmpleados?faces-redirect=true";
    
    }
      
        public void obtenerusuEmpleados() {
        String idUsuarioEmpleados = JsfUtil.getRequest().getParameter("idUsuarioEmpleados");
        usuEmpleados = modelo.obtenerusuEmpleados(idUsuarioEmpleados);
    }
        
    
public String loginControl(){
if(modelo.loginControl(usuarioEmp,passwordEmp)){
return "registroClientes.xhtml?faces-redirect=true";
}
FacesContext context = FacesContext.getCurrentInstance();
context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "usuario o password invalidos", "Error de acceso"));
return "";
}
    
}

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
import entidades.EmpleadoEntity;
import entidades.PerfilempleadosEntity;
import java.util.List;
import modelo.ClientesModel;
import modelo.EmpleadosModel;
import modelo.PerfilesModel;
import utils.JpaUtil;
/**
 *
 * @author Usuario
 */
@ManagedBean
@RequestScoped
public class PerfilesBean {

    
    PerfilesModel modelo = new PerfilesModel();
    private PerfilempleadosEntity perfil;
        private List<PerfilempleadosEntity> listaPerfil;

    /**
     * Creates a new instance of ClientesBean
     */
    public PerfilesBean() {
        perfil = new PerfilempleadosEntity();
    }
    
    public PerfilempleadosEntity getPerfil(){
        return perfil;
    }
    public void SetPerfil(PerfilempleadosEntity perfil){
        this.perfil = perfil;
    }
    
    public List<PerfilempleadosEntity> getListaPerfiles(){
        return modelo.listarPerfiles();
    }
    
     public String guardarPerfil() {
        if (modelo.insertarPerfil(perfil) != 1) {
            modificarPerfil();
            return "registroPerfil?faces-redirect=true";
        } else {
            JsfUtil.setFlashMessage("exito", "Empleado registrado exitosamente");
            //Forzando la redirección en el cliente
            return "registroPerfil?faces-redirect=true";
        }
    }
     
     public String eliminarPerfil() {
// Leyendo el parametro enviado desde la vista
        String idPerfilEmpleados = JsfUtil.getRequest().getParameter("idPerfilEmpleados");
        if (modelo.eliminarPerfil(idPerfilEmpleados) > 0) {
            JsfUtil.setFlashMessage("exito", "Empleado eliminado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "No se pudo borrar a este Empleado");
        }
        return "registroPerfil?faces-redirect=true";
    }
     
      public String modificarPerfil() {
        if (modelo.modificarPerfil(perfil) > 0) {
            JsfUtil.setFlashMessage("exito", "Empleado modificado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "Nose pudo modificar el Cliente");
        }
        return "registroPerfil?faces-redirect=true";
    
    }
      
        public void obtenerPerfil() {
        String idPerfilEmpleados = JsfUtil.getRequest().getParameter("idPerfilEmpleados");
        Integer id = Integer.parseInt(idPerfilEmpleados);
        perfil = modelo.obtenerPerfil(id);
    }
        
}

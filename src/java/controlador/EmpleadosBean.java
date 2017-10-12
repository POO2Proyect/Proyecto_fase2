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
import java.util.List;
import modelo.ClientesModel;
import modelo.EmpleadosModel;
import utils.JpaUtil;
/**
 *
 * @author Usuario
 */
@ManagedBean
@RequestScoped
public class EmpleadosBean {

    
    EmpleadosModel modelo = new EmpleadosModel();
    private EmpleadoEntity empleados;
        private List<ClientesEntity> listaEmpleados;

    /**
     * Creates a new instance of ClientesBean
     */
    public EmpleadosBean() {
        empleados = new EmpleadoEntity();
    }
    
    public EmpleadoEntity getEmpleados(){
        return empleados;
    }
    public void SetEmpleados(EmpleadoEntity empleados){
        this.empleados = empleados;
    }
    
    public List<EmpleadoEntity> getListaEmpleados(){
        return modelo.listarEmpleados();
    }
    
     public String guardarEmpleados() {
        if (modelo.insertarEmpleados(empleados) != 1) {
            modificarEmpleados();
            return "registroEmpleados?faces-redirect=true";
        } else {
            JsfUtil.setFlashMessage("exito", "Empleado registrado exitosamente");
            //Forzando la redirección en el cliente
            return "registroEmpleados?faces-redirect=true";
        }
    }
     
     public String eliminarEmpleados() {
// Leyendo el parametro enviado desde la vista
        String idEmpleado = JsfUtil.getRequest().getParameter("idEmpleado");
        if (modelo.eliminarEmpleados(idEmpleado) > 0) {
            JsfUtil.setFlashMessage("exito", "Empleado eliminado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "No se pudo borrar a este Empleado");
        }
        return "registroEmpleados?faces-redirect=true";
    }
     
      public String modificarEmpleados() {
        if (modelo.modificarEmpleados(empleados) > 0) {
            JsfUtil.setFlashMessage("exito", "Empleado modificado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "Nose pudo modificar el Cliente");
        }
        return "registroEmpleados?faces-redirect=true";
    
    }
      
        public void obtenerEmpleados() {
        String idEmpleado = JsfUtil.getRequest().getParameter("idEmpleado");
        empleados = modelo.obtenerEmpleados(idEmpleado);
    }
        
}

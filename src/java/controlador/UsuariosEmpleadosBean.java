/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.sun.xml.internal.ws.client.RequestContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import entidades.UsuariosempleadosEntity;
import modelo.UsuariosEmpleadosModel;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    
    UsuariosEmpleadosModel modelo = new UsuariosEmpleadosModel();
    private String passwordEmp;
    private String usuarioEmp;
    /**
     * Creates a new instance of UsuariosEmpleadosBean
     */
    public UsuariosEmpleadosBean() {
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

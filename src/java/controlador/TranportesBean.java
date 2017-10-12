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
import entidades.TransporteEntity;
import java.util.List;
import modelo.ClientesModel;
import modelo.EmpleadosModel;
import modelo.TransportesModel;
import utils.JpaUtil;
/**
 *
 * @author Usuario
 */
@ManagedBean
@RequestScoped
public class TranportesBean {

    
    TransportesModel modelo = new TransportesModel();
    private TransporteEntity transportes;
        private List<TransporteEntity> listaTransportes;

    /**
     * Creates a new instance of ClientesBean
     */
    public TranportesBean() {
        transportes = new TransporteEntity();
    }
    
    public TransporteEntity getTransportes(){
        return transportes;
    }
    public void SetTranportes(TransporteEntity transportes){
        this.transportes = transportes;
    }
    
    public List<TransporteEntity> getListaTransportes(){
        return modelo.listarTransportes();
    }
    
     public String guardarTransportes() {
        if (modelo.insertarTransportes(transportes) != 1) {
            modificarTransportes();
            return "registroTransportes?faces-redirect=true";
        } else {
            JsfUtil.setFlashMessage("exito", "Transporte registrado exitosamente");
            //Forzando la redirección en el cliente
            return "registroTransportes?faces-redirect=true";
        }
    }
     
     public String eliminarTransportes() {
// Leyendo el parametro enviado desde la vista
        String idTransporte = JsfUtil.getRequest().getParameter("idTransporte");
        if (modelo.eliminarTransportes(idTransporte) > 0) {
            JsfUtil.setFlashMessage("exito", "Transporte eliminado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "No se pudo borrar este Transporte");
        }
        return "registroTransportes?faces-redirect=true";
    }
     
      public String modificarTransportes() {
        if (modelo.modificarTransportes(transportes) > 0) {
            JsfUtil.setFlashMessage("exito", "Transporte modificado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "Nose pudo modificar el Transporte");
        }
        return "registroTransportes?faces-redirect=true";
    
    }
      
        public void obtenerTransportes() {
        String idTransporte = JsfUtil.getRequest().getParameter("idTransporte");
        transportes = modelo.obtenerTransportes(idTransporte);
    }
        
}

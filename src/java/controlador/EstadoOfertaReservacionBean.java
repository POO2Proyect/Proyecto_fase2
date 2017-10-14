/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utils.JsfUtil;
import java.util.List;
import utils.JpaUtil;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import entidades.EstadoofertareservacionEntity;
import modelo.EstadoOfertaModel;
/**
 *
 * @author Nestor2
 */
@ManagedBean
@SessionScoped
public class EstadoOfertaReservacionBean {

    
    EstadoOfertaModel modelo = new EstadoOfertaModel();
    private EstadoofertareservacionEntity estado;
    private List<EstadoofertareservacionEntity> listaEstado;

    
     public List<EstadoofertareservacionEntity> getListaEstado(){
        return modelo.listarEstadOferta();
    }
    public EstadoofertareservacionEntity getEstado() {
        return estado;
    }

    public void setEstado(EstadoofertareservacionEntity estado) {
        this.estado = estado;
    }
    
    /**
     * Creates a new instance of EstadoOfertaReservacionBean
     */
    public EstadoOfertaReservacionBean() {
        
         estado = new EstadoofertareservacionEntity();
    }
    
      public String guardarEstado() {
        if (modelo.insertarEstadoOferta(estado) != 1) {
            
            return "registroEstado?faces-redirect=true";
        } else {
            JsfUtil.setFlashMessage("exito", "Estado registrado exitosamente");
            //Forzando la redirección en el usuario
            return "EstadoOferta?faces-redirect=true";
        }
    }
      
       public String eliminarEstado() {
// Leyendo el parametro enviado desde la vista
        String idEstado = JsfUtil.getRequest().getParameter("idEstado");
        int destino;
        destino=Integer.parseInt(idEstado);
        if (modelo.eliminarEstadoOferta(destino) > 0) {
            JsfUtil.setFlashMessage("exito", "Estado eliminado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "");
        }
        return "EstadoOferta?faces-redirect=true";
    }
    
        public void obtenerEstadOferta() {
        String idOferta = JsfUtil.getRequest().getParameter("idOferta");
        Integer id = Integer.parseInt(idOferta);
        estado= modelo.obtenerEstadOferta(id);
    }
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utils.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import entidades.OfertasEntity;
import modelo.OfertasModel;
import modelo.EstadoOfertaModel;
import entidades.EstadoofertareservacionEntity;
/**
 *
 * @author Nestor2
 */
@ManagedBean
@SessionScoped
public class OfertasBean {

    OfertasModel modelo = new OfertasModel();
    private OfertasEntity ofertas;

    public OfertasEntity getOfertas() {
        return ofertas;
    }

    public void setOfertas(OfertasEntity ofertas) {
        this.ofertas = ofertas;
    }
    
    
    private List<OfertasEntity> listaOfertas;
    public List<OfertasEntity> getListaOfertas(){
        return modelo.listarOferta();        
    }
      private List<SelectItem> listaEstado;

    public List<SelectItem> getListaEstado() {
        this.listaEstado = new ArrayList<SelectItem>();
        EstadoOfertaModel  mod = new EstadoOfertaModel();
        List<EstadoofertareservacionEntity> e = mod.listarEstadOferta();
        
        for (EstadoofertareservacionEntity estados : e){
            SelectItem EstadoItem = new SelectItem(estados.getIdEstadoOfertaReservacion());
            this.listaEstado.add(EstadoItem);
        }
        return listaEstado;
    }

    public void setListaEstado(List<SelectItem> listaEstado) {
        this.listaEstado = listaEstado;
    }
      
    public OfertasBean() {
        ofertas = new OfertasEntity();
    }
    
    
      public String guardarOferta() {
        if (modelo.insertarOferta(ofertas) != 1) {
            
            return "registroOfertas?faces-redirect=true";
        } else {
            JsfUtil.setFlashMessage("exito", "Oferta registrada exitosamente");
            //Forzando la redirección en el usuario
            return "registroOfertas?faces-redirect=true";
        }
    }
      
       public String eliminarOferta() {
// Leyendo el parametro enviado desde la vista
        String idOferta = JsfUtil.getRequest().getParameter("idOferta");
        if (modelo.eliminarOferta(idOferta) > 0) {
            JsfUtil.setFlashMessage("exito", "Oferta eliminada exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "no se pudo eliminar oferta");
        }
        return "registroOfertas?faces-redirect=true";
    }
       
       public String modificarOferta() {
        if (modelo.modificarOferta(ofertas) > 0) {
            JsfUtil.setFlashMessage("exito", "Oferta eliminada exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "");
        }
        return "registroOfertas?faces-redirect=true";
    
    }
       
        public void obtenerOferta() {
        String idOferta = JsfUtil.getRequest().getParameter("idOferta");
        ofertas= modelo.obtenerOferta(idOferta);
    }
    
}

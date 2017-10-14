/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.CabanasEntity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utils.JpaUtil;
import utils.JsfUtil;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import modelo.ServiciosModel;
import modelo.ToursModel;
import modelo.TransportesModel;
import modelo.CabanasModel;
import entidades.ServiciosEntity;
import entidades.TourEntity;
import entidades.TransporteEntity;
import java.util.List;


/**
 *
 * @author Nestor2
 */
@ManagedBean
@SessionScoped
public class ServiciosBean {
  
    ServiciosModel servicioModelo = new ServiciosModel();
    private ServiciosEntity servicios;

    public ServiciosEntity getServicios() {
        return servicios;
    }

    public void setServicios(ServiciosEntity servicios) {
        this.servicios = servicios;
    }
    
    private List<ServiciosEntity> listaServicios;
     public List<ServiciosEntity> getListaServicios(){
        return servicioModelo.listarServicios();
     }
     
         private List<SelectItem> listaCabañas;
         private List<SelectItem> listaTransporte;
         private List<SelectItem> listaTour;
         
         
        public List<SelectItem> getListaCabañas() {
        this.listaCabañas = new ArrayList<SelectItem>();
       CabanasModel model = new CabanasModel();
       List<CabanasEntity> c = model.listarCabanas();
       
       
       for (CabanasEntity cabanas : c){
           SelectItem CabanaItem = new SelectItem(cabanas.getIdCabanas(),cabanas.getNombre());
           this.listaCabañas.add(CabanaItem);
       }
        return listaCabañas;    
    }

    public void setListaCabañas(List<SelectItem> listaCabañas) {
        this.listaCabañas = listaCabañas;
    }
    
    public List<SelectItem> getListaTransporte(){
        this.listaTransporte = new ArrayList<SelectItem>();
        TransportesModel transporteModel = new TransportesModel();
       List<TransporteEntity> t = transporteModel.listarTransportes();
       
       for (TransporteEntity transporte : t){
           SelectItem transporteItem = new SelectItem(transporte.getIdTransporte(),transporte.getModelo());
           this.listaTransporte.add(transporteItem);
       }
        return listaTransporte;
    }
    
    public void setListaTransporte(List<SelectItem> listaTransporte){
      this.listaTransporte = listaTransporte;  
    }
    
    public List<SelectItem> getListaTour(){
        this.listaTour = new ArrayList<SelectItem>();
        ToursModel tourModel = new ToursModel();
        List<TourEntity> to = tourModel.listarTours();
        
        for (TourEntity tour : to){
          SelectItem tourItem = new SelectItem(tour.getIdTour(),tour.getNombre());
          this.listaTour.add(tourItem);
        }
        return listaTour;
    }

    public void setListaTour(List<SelectItem> listaTour){
        this.listaTour = listaTour;
    }
    
    /**
     * Creates a new instance of ServiciosBean
     */
    public ServiciosBean() {
       servicios= new ServiciosEntity();
    }
    
     public String guardarServicio() {
        if (servicioModelo.insertarServicio(servicios) != 1) {
            
            return "registroServicios?faces-redirect=true";
        } else {
            JsfUtil.setFlashMessage("exito", "Servicios registrado exitosamente");
            //Forzando la redirección en el usuario
            return "registroServicios?faces-redirect=true";
        }
    }
    
     public String eliminarServicio() {
// Leyendo el parametro enviado desde la vista
        String idServicio = JsfUtil.getRequest().getParameter("idServicio");
        if (servicioModelo.eliminarServicio(idServicio) > 0) {
            JsfUtil.setFlashMessage("exito", "Servicio eliminado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "");
        }
        return "registroServicios?faces-redirect=true";
    }
     
      public String modificarServicio() {
        if (servicioModelo.modificarServicio(servicios) > 0) {
            JsfUtil.setFlashMessage("exito", "Servicio modificado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "");
        }
        return "registroServicios?faces-redirect=true";
    
    }
       public void obtenerServicio() {
        String idServicio = JsfUtil.getRequest().getParameter("idServicio");
        servicios = servicioModelo.obtenerServicio(idServicio);
    }
       
     
}

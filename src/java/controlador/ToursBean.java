package controlador;

import entidades.TipodestinoEntity;
import entidades.TourEntity;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import modelo.TipoDestinoModel;
import modelo.ToursModel;
import utils.JsfUtil;

/**
 * @author Usuario
 */
@ManagedBean
@RequestScoped
public class ToursBean {
    
    ToursModel modelo = new ToursModel();
    private TourEntity tour;
    private TipodestinoEntity Tipotour;
    private List<TourEntity> listaTour;
    private List<SelectItem> listaTipoDestino;

    /**
     * Creates a new instance of ClientesBean
     */
    public ToursBean() {
        tour = new TourEntity();
    }
    
    public TourEntity getTour() {
        return tour;
    }

    public void setTour(TourEntity tour) {
        this.tour = tour;
    }

    public TipodestinoEntity getTipotour() {
        return Tipotour;
    }

    public void setTipotour(TipodestinoEntity Tipotour) {
        this.Tipotour = Tipotour;
    }
    
    public List<TourEntity> getListaTour() {
        return modelo.listarTours();
    }
    
    public List<SelectItem> getListaTipoDestino() {
        this.listaTipoDestino = new ArrayList<SelectItem>();
        TipoDestinoModel modelo = new TipoDestinoModel();
        List<TipodestinoEntity> c = modelo.listarTipoDestino();
        
        for(TipodestinoEntity destino: c){
            SelectItem tipoDestinoItem = new SelectItem(destino.getIdTipoDestino(), destino.getNombre());
            this.listaTipoDestino.add(tipoDestinoItem);
        }
        return listaTipoDestino;
    }

    
     public String guardarTours() {
        if (modelo.insertarTours(tour) != 1) {
            modificarTours();
            return "registroTour?faces-redirect=true";
        } else {
            JsfUtil.setFlashMessage("exito", "Tours registrado exitosamente");
            //Forzando la redirección en el cliente
            return "registroTour?faces-redirect=true";
        }
    }
     
     public String eliminarTours() {
// Leyendo el parametro enviado desde la vista
        String idTours = JsfUtil.getRequest().getParameter("idTour");
        if (modelo.eliminarTours(idTours) > 0) {
            JsfUtil.setFlashMessage("exito", "Tours eliminado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "No se pudo borrar a este Tours");
        }
        return "registroTour?faces-redirect=true";
    }
     
      public String modificarTours() {
        if (modelo.modificarTours(tour) > 0) {
            JsfUtil.setFlashMessage("exito", "Tours modificado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "Nose pudo modificar el Tours");
        }
        return "registroTour?faces-redirect=true";
    
    }
      
        public void obtenerTours() {
        String idTour = JsfUtil.getRequest().getParameter("idTour");
        tour = modelo.obtenerTour(idTour);
    }
}

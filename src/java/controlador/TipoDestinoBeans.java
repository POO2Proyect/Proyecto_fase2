package controlador;

import entidades.TipodestinoEntity;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.TipoDestinoModel;
import utils.JsfUtil;

/**
 * @author Usuario
 */
@ManagedBean
@RequestScoped
public class TipoDestinoBeans {

    TipoDestinoModel modelo = new TipoDestinoModel();
    private TipodestinoEntity destino;
    private List<TipodestinoEntity> listarTipoDestino;

    /**
     * Creates a new instance of ClientesBean
     */
    
    public TipoDestinoBeans() {
        destino = new TipodestinoEntity();
    }
    
    public TipodestinoEntity getDestino(){
        return destino;
    }
    public void setDestino(TipodestinoEntity destino){
        this.destino = destino;
    }
    
    public List<TipodestinoEntity> getListarTipoDestino(){
        return modelo.listarTipoDestino();
    }
    
     public String guardarDestino() {
        if (modelo.insertarDestino(destino) != 1) {
            modificarDestino();
            return "registroTipoDestino?faces-redirect=true";
        } else {
            JsfUtil.setFlashMessage("exito", "Destino registrado exitosamente");
            //Forzando la redirección en el cliente
            return "registroTipoDestino?faces-redirect=true";
        }
    }
     
     public String eliminarDestino() {
        // Leyendo el parametro enviado desde la vista
        String iddestino = JsfUtil.getRequest().getParameter("idDestino");
        int idDestino;
        idDestino = Integer.parseInt(iddestino);
        if (modelo.eliminarDestino(idDestino) > 0) {
            JsfUtil.setFlashMessage("exito", "Destino eliminado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "No se pudo borrar a este destino");
        }
        return "registroTipoDestino?faces-redirect=true";
    }
     
      public String modificarDestino() {
        if (modelo.modificarDestino(destino) > 0) {
            JsfUtil.setFlashMessage("exito", "Destino modificado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "Nose pudo modificar el Destino");
        }
        return "registroTipoDestino?faces-redirect=true";
    
    }
      
        public void obtenerDestino() {
        String iddestino = JsfUtil.getRequest().getParameter("idDestino");
        int idDestino;
        idDestino = Integer.parseInt(iddestino);
        System.out.println(idDestino);
        destino = modelo.obtenerDestino(idDestino);
    }
    
}

package controlador;

import entidades.CabanasEntity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import utils.JsfUtil;
import entidades.ClientesEntity;
import java.util.List;
import modelo.CabanasModel;
import modelo.ClientesModel;
import utils.JpaUtil;

/**
 * @author Usuario
 */
@ManagedBean
@RequestScoped
public class CabanasBean {
    
    CabanasModel cabanasM = new CabanasModel();
    private CabanasEntity cabanas;
    private List<CabanasEntity> listaCabanas;
    

    public CabanasBean() {
        cabanas = new CabanasEntity();
    }

    public CabanasEntity getCabanas() {
        return cabanas;
    }

    public void setCabanas(CabanasEntity cabanas) {
        this.cabanas = cabanas;
    }

    public List<CabanasEntity> getListaCabanas() {
        return cabanasM.listarCabanas();
    }

    public String guardarCabana(){
        if(cabanasM.insertarCabana(cabanas) != 1){
            modificarCabana();
            return "registroCabanas?faces-redirect?true";
        }else {
            JsfUtil.setFlashMessage("exito", "Cliente registrado exitosamente");
            //Forzando la redirección en el cliente
            return "registroCabanas?faces-redirect=true";
        }
    }

    private String modificarCabana() {
        if (cabanasM.modificarCabana(cabanas) > 0) {
            JsfUtil.setFlashMessage("exito", "Cliente modificado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "Nose pudo modificar el Cliente");
        }
        return "registroCabanas?faces-redirect=true";
    }
    
     public String eliminarCabana() {
        // Leyendo el parametro enviado desde la vista
        String idCabana = JsfUtil.getRequest().getParameter("idCabana");
        if (cabanasM.eliminarCabana(idCabana) > 0) {
            JsfUtil.setFlashMessage("exito", "Cliente eliminado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "No se pudo borrar a este cliente");
        }
        return "registroCabanas?faces-redirect=true";
    }
     
     public void obtenerCabana(){
         String idCabana = JsfUtil.getRequest().getParameter("idCabanas");
         cabanas = cabanasM.obtenerCabanas(idCabana);
     }
    
}

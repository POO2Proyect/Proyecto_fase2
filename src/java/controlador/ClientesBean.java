package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import utils.JsfUtil;
import entidades.ClientesEntity;
import java.util.List;
import modelo.ClientesModel;
import utils.JpaUtil;

/**
 * @author Usuario
 */
@ManagedBean
@RequestScoped
public class ClientesBean {

    
    ClientesModel modelo = new ClientesModel();
    private ClientesEntity cliente;
        private List<ClientesEntity> listaClientes;

    /**
     * Creates a new instance of ClientesBean
     */
    public ClientesBean() {
        cliente = new ClientesEntity();
    }
    
    public ClientesEntity getClientes(){
        return cliente;
    }
    public void SetCliente(ClientesEntity cliente){
        this.cliente = cliente;
    }
    
    public List<ClientesEntity> getListaClientes(){
        return modelo.listarClientes();
    }
    
     public String guardarCliente() {
        if (modelo.insertarCliente(cliente) != 1) {
            modificarCliente();
            return "registroClientes?faces-redirect=true";
        } else {
            JsfUtil.setFlashMessage("exito", "Cliente registrado exitosamente");
            //Forzando la redirección en el cliente
            return "registroClientes?faces-redirect=true";
        }
    }
     
     public String eliminarCliente() {
// Leyendo el parametro enviado desde la vista
        String idCliente = JsfUtil.getRequest().getParameter("idCliente");
        if (modelo.eliminarCliente(idCliente) > 0) {
            JsfUtil.setFlashMessage("exito", "Cliente eliminado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "No se pudo borrar a este cliente");
        }
        return "registroClientes?faces-redirect=true";
    }
     
      public String modificarCliente() {
        if (modelo.modificarCliente(cliente) > 0) {
            JsfUtil.setFlashMessage("exito", "Cliente modificado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "Nose pudo modificar el Cliente");
        }
        return "registroClientes?faces-redirect=true";
    
    }
      
        public void obtenerCliente() {
        String idCliente = JsfUtil.getRequest().getParameter("idCliente");
        cliente = modelo.obtenerCliente(idCliente);
    }
        
}

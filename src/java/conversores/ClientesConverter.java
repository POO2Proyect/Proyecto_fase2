
package conversores;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import modelo.ClientesModel;
import entidades.ClientesEntity;

@FacesConverter(forClass=ClientesEntity.class)

public class ClientesConverter implements Converter {
    
        ClientesModel cl = new ClientesModel();


    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       
         if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            ClientesEntity clientes= cl.obtenerCliente(value);
            return clientes;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
     
         if (value == null) {
            return "";
        }

        if (value instanceof ClientesEntity) {
            return ((ClientesEntity) value).getIdClientes();
        } else {
            return "";
        }
    }
    
    
    
}

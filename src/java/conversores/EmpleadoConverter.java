
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
import entidades.EmpleadoEntity;
import modelo.EmpleadosModel;

@FacesConverter(forClass=EmpleadoEntity.class)

public class EmpleadoConverter implements Converter {
    
       EmpleadosModel cl = new EmpleadosModel();


    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       
         if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            EmpleadoEntity empleados= cl.obtenerEmpleados(value);
            return empleados;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
     
         if (value == null) {
            return "";
        }

        if (value instanceof EmpleadoEntity) {
            return ((EmpleadoEntity) value).getIdEmpleado();
        } else {
            return "";
        }
    }
    
    
    
}

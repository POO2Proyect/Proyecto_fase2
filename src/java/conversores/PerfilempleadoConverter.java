
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
import entidades.PerfilempleadosEntity;
import modelo.EmpleadosModel;
import modelo.PerfilesModel;

@FacesConverter(forClass=PerfilempleadosEntity.class)

public class PerfilempleadoConverter implements Converter {
    
       PerfilesModel cl = new PerfilesModel();


    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         
         if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            int id = Integer.parseInt(value);
           PerfilempleadosEntity perfil= cl.obtenerPerfil(id);
            return perfil;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
     
         if (value == null) {
            return "";
        }

        if (value instanceof PerfilempleadosEntity) {
            return ((PerfilempleadosEntity) value).getIdPerfilEmpleados().toString();
        } else {
            return "";
        }
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import entidades.CabanasEntity;
import modelo.CabanasModel;
/**
 *
 * @author Nestor2
 */
public class CabanaConverter implements Converter {

    
    CabanasModel cab = new CabanasModel();
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            CabanasEntity cabana= cab.obtenerCabanas(value);
            return cabana;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
       if (value == null) {
            return "";
        }

        if (value instanceof CabanasEntity) {
            return ((CabanasEntity) value).getIdCabanas();
        } else {
            return "";
        }  
    }
    
    
    
}

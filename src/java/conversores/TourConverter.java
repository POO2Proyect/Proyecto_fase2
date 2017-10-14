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
import entidades.TourEntity;
import modelo.ToursModel;

/**
 *
 * @author Nestor2
 */
@FacesConverter(forClass=TourEntity.class)

public class TourConverter implements Converter {
    
    ToursModel modelo = new ToursModel();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            TourEntity tour= modelo.obtenerTour(value);
            return tour;
        } catch (Exception e) {
            return null;
        }
 
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if (value == null) {
            return "";
        }

        if (value instanceof TourEntity) {
            return ((TourEntity) value).getIdTour();
        } else {
            return "";
        }
    }
    
    
    
}

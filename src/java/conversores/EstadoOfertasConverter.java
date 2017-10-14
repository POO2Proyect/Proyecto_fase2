/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.IntegerConverter;
import javax.faces.convert.FacesConverter;
import entidades.EstadoofertareservacionEntity;
import modelo.EstadoOfertaModel;
import modelo.OfertasModel;
/**
 *
 * @author Nestor2
 */
@FacesConverter(forClass=EstadoofertareservacionEntity.class)

    public class EstadoOfertasConverter implements Converter {
    
    EstadoOfertaModel oferta = new EstadoOfertaModel();
    OfertasModel  oferta2 = new OfertasModel();

   
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    // int id = Integer.parseInt(value);
    
      if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            int id= Integer.parseInt(value);
          EstadoofertareservacionEntity estado= oferta.obtenerEstadOferta(id);
            return estado;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
           if (value == null) {
            return "";
        }

        if (value instanceof EstadoofertareservacionEntity) {
            return ((EstadoofertareservacionEntity) value).getIdEstadoOfertaReservacion().toString();
        } else {
            return "";
        }
    }
    
    }
   

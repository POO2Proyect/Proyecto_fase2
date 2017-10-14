package conversores;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import entidades.TipodestinoEntity;
import modelo.TipoDestinoModel;

@FacesConverter(forClass=TipodestinoEntity.class)

public class DestinoConverter implements Converter {
    
        TipoDestinoModel cl = new TipoDestinoModel();


    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       
         if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            int id;
            id = Integer.parseInt(value);
            TipodestinoEntity destino= cl.obtenerDestino(id);
            return destino;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
     
         if (value == null) {
            return null;
        }

        if (value instanceof TipodestinoEntity) {
            return ((TipodestinoEntity) value).getIdTipoDestino().toString();
        } else {
            return "";
        }
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cnv;

import domen.Katedra;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import logika.Kontroler;

/**
 *
 * @author Sara
 */
@FacesConverter(forClass = Katedra.class, value = "CNVKatedra")
public class CNVKatedra implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         if (!value.isEmpty()) {
            int katedraID= Integer.parseInt(value);
            Katedra k = Kontroler.getInstance().vratiKatedru(katedraID);
            return k;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if (value instanceof Katedra) {

            Katedra k = (Katedra) value;
            return k.getSifraKatedre().toString();
        }
        return "";
    }
    
}

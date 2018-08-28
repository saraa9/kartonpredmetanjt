/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.Katedra;

import domen.Katedra;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Sara
 */
public class SOVratiSveKatedre extends OpstaSO{
    List<Katedra> listaKatedri;

    public List<Katedra> getListaKatedri() {
        return listaKatedri;
    }

    public void setListaKatedri(List<Katedra> listaKatedri) {
        this.listaKatedri = listaKatedri;
    }
    
    @Override
    public void izvrsiKonkretnuOperaciju(Object objekat) throws Exception {
        System.out.println("izvrsi kontrernu operaciju");
         listaKatedri = db.DBBroker.getInstance().vratiSveKatedre((Katedra) objekat);
    }
    
}

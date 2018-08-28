/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.Katedra;

import db.DBBroker;
import domen.Katedra;
import so.OpstaSO;

/**
 *
 * @author Sara
 */
public class SOVratiKatedru extends OpstaSO{
    private Katedra k;
    
    @Override
    public void izvrsiKonkretnuOperaciju(Object objekat) throws Exception {
        Katedra ka = new Katedra();
        ka.setSifraKatedre((Integer) objekat);
        k = DBBroker.getInstance().vratiKatedru((Katedra)ka);
    }

    public Katedra getK() {
        return k;
    }

    public void setK(Katedra k) {
        this.k = k;
    }
    
}

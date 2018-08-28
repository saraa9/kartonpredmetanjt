/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;

/**
 *
 * @author Sara
 */
public abstract class OpstaSO {
     public final void izvrsiOperaciju(Object o) throws Exception {
        try {
          
            DBBroker.getInstance().zapocniTransakciju();
        
            izvrsiKonkretnuOperaciju(o);
            DBBroker.getInstance().commit();
        } catch (Exception e) {
            DBBroker.getInstance().rollback();
            throw e;
        } finally {
            DBBroker.getInstance().zatvoriEntityManager();
        }
    }

    public abstract void izvrsiKonkretnuOperaciju(Object objekat) throws Exception;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.Korisnik;

import domen.Korisnik;
import so.OpstaSO;

/**
 *
 * @author Irena
 */
public class SOVratiKorisnika extends OpstaSO{

    private Korisnik korisnik;
    
    @Override
    public void izvrsiKonkretnuOperaciju(Object objekat) throws Exception {
               System.out.println("SO: "+((Korisnik)objekat).getLozinka()+((Korisnik)objekat).getKorisnickoIme());

      korisnik = db.DBBroker.getInstance().vratiObjekat((Korisnik) objekat);
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setRadnik(Korisnik korisnik) {
        this.korisnik= korisnik;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.Katedra;
import domen.Korisnik;
import java.util.List;
import so.Katedra.SOVratiKatedru;
import so.Katedra.SOVratiSveKatedre;
import so.Korisnik.SOVratiKorisnika;

/**
 *
 * @author Sara
 */
public class Kontroler {
    private static Kontroler instanca;

    private Kontroler() {

    }

    public static Kontroler getInstance() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public List<Katedra> vratiListuKatedri() throws Exception {
        System.out.println("uslo u vrati listu katedri");
        SOVratiSveKatedre so = new SOVratiSveKatedre();
        so.izvrsiOperaciju(new Katedra());
        for (Katedra k : so.getListaKatedri()) {
            System.out.println("lista: "+k);
        }
        return so.getListaKatedri();
    }

    public Katedra vratiKatedru(int katedraID) {
         SOVratiKatedru so = new SOVratiKatedru();
        try {
            so.izvrsiOperaciju(katedraID);
        } catch (Exception exception) {
            System.out.println("Kontroler: Sistem ne moze da nadje katedru za unetu katedruID");
        }
        return so.getK();
    }
    
     public Korisnik vratiKorisnika(Korisnik korisnik) throws Exception {
        SOVratiKorisnika so = new SOVratiKorisnika();
        so.izvrsiOperaciju(korisnik);
        return so.getKorisnik();
    }
}

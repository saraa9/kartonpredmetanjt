/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;


import domen.Korisnik;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.enterprise.context.SessionScoped;
import logika.Kontroler;





@SessionScoped
@Named("mbLogin")
public class MBLogin implements Serializable {

    /**
     * Creates a new instance of MBLogin
     */
 
    Korisnik korisnik;

  
    
    private boolean ulogovan = false;
    private static final Logger LOG = Logger.getLogger(MBLogin.class.getName());

    public MBLogin() {
           korisnik=new Korisnik();
    }

      public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    

  

    public boolean isUlogovan() {
        return ulogovan;
    }

    public void setUlogovan(boolean ulogovan) {
        this.ulogovan = ulogovan;
    }

   

    public void login() {
        //nije ulogovan
  
        if (!ulogovan) {
            FacesMessage msg = null;
            Korisnik k=null;
            try {
                System.out.println("uslo u login");
                k= Kontroler.getInstance().vratiKorisnika(korisnik);
                
                if (k!=null) {
                    ulogovan = true;
                    korisnik = k;
                    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dobrodošli, " + k.getKorisnickoIme(), "");

                } else {
                    msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Uneli ste pogrešno korisničko ime ili lozinku", null);
                }
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception ex) {
                LOG.log(Level.SEVERE, ex.getMessage());
                ex.printStackTrace();
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Nastala je greška prilikom prijavljivanja korisnika", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }

        }
    }

    

    public String izlogujSe() {
        korisnik = new Korisnik();
        ulogovan = false;
        return "index.xhtml?faces-redirect=true";
    }

    public String vratiUlogovanogKorisnika() {
        return korisnik.getKorisnickoIme();
    }

}

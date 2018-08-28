/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import domen.Katedra;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import logika.Kontroler;

/**
 *
 * @author Sara
 */
@Named(value = "mBKatedra")
@RequestScoped
public class MBKatedra implements Serializable{
    private Katedra katedra;
    private List<Katedra> listaKatedri;
    /**
     * Creates a new instance of MBKatedra
     */
    public MBKatedra() {
        katedra = new Katedra();
        System.out.println("uslo u mb katedra");
        listaKatedri = new LinkedList<>();
    }
    @PostConstruct
    public void inicijalizujPodatke() {
        FacesMessage msg;
        try {
            System.out.println("uslo u inicijalizuj");
            listaKatedri = Kontroler.getInstance().vratiListuKatedri();
            System.out.println("lista katedri:");
            for (Katedra katedra1 : listaKatedri) {
                System.out.println("***"+katedra1);
            }
        } catch (Exception ex) {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Nastala je greška prilikom prikazivanja katedri", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public Katedra getKatedra() {
        return katedra;
    }

    public void setKatedra(Katedra katedra) {
        this.katedra = katedra;
    }

    public List<Katedra> getListaKatedri() {
        return listaKatedri;
    }

    public void setListaKatedri(List<Katedra> listaKatedri) {
        this.listaKatedri = listaKatedri;
    }

}

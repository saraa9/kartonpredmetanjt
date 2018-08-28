/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import domen.Predmet;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Sara
 */
@Named(value = "mbPredmet")
@ViewScoped
public class MBPredmet implements Serializable{
    private Predmet predmet;

    public MBPredmet() {
        System.out.println("uslo u mb predmet");
        predmet=new Predmet();
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }
    
    
    
}

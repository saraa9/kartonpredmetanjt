/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sara
 */
@Entity
@Table(name = "predmetzaposleni")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Predmetzaposleni.findAll", query = "SELECT p FROM Predmetzaposleni p")
    , @NamedQuery(name = "Predmetzaposleni.findByPredmetID", query = "SELECT p FROM Predmetzaposleni p WHERE p.predmetzaposleniPK.predmetID = :predmetID")
    , @NamedQuery(name = "Predmetzaposleni.findByZaposleniID", query = "SELECT p FROM Predmetzaposleni p WHERE p.predmetzaposleniPK.zaposleniID = :zaposleniID")
    , @NamedQuery(name = "Predmetzaposleni.findByTipNastave", query = "SELECT p FROM Predmetzaposleni p WHERE p.tipNastave = :tipNastave")})
public class Predmetzaposleni implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PredmetzaposleniPK predmetzaposleniPK;
    @Size(max = 30)
    @Column(name = "tipNastave")
    private String tipNastave;
    @JoinColumn(name = "predmetID", referencedColumnName = "predmetID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Predmet predmet;
    @JoinColumn(name = "zaposleniID", referencedColumnName = "zaposleniID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Zaposleni zaposleni;
    @JoinColumn(name = "studijskiProgramPredmetID", referencedColumnName = "studijskiProgramID")
    @ManyToOne
    private Studijskiprogramsemestar studijskiProgramPredmetID;
    @JoinColumn(name = "predmetID", referencedColumnName = "predmetID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Studijskiprogramsemestar studijskiprogramsemestar;

    public Predmetzaposleni() {
    }

    public Predmetzaposleni(PredmetzaposleniPK predmetzaposleniPK) {
        this.predmetzaposleniPK = predmetzaposleniPK;
    }

    public Predmetzaposleni(int predmetID, int zaposleniID) {
        this.predmetzaposleniPK = new PredmetzaposleniPK(predmetID, zaposleniID);
    }

    public PredmetzaposleniPK getPredmetzaposleniPK() {
        return predmetzaposleniPK;
    }

    public void setPredmetzaposleniPK(PredmetzaposleniPK predmetzaposleniPK) {
        this.predmetzaposleniPK = predmetzaposleniPK;
    }

    public String getTipNastave() {
        return tipNastave;
    }

    public void setTipNastave(String tipNastave) {
        this.tipNastave = tipNastave;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Studijskiprogramsemestar getStudijskiProgramPredmetID() {
        return studijskiProgramPredmetID;
    }

    public void setStudijskiProgramPredmetID(Studijskiprogramsemestar studijskiProgramPredmetID) {
        this.studijskiProgramPredmetID = studijskiProgramPredmetID;
    }

    public Studijskiprogramsemestar getStudijskiprogramsemestar() {
        return studijskiprogramsemestar;
    }

    public void setStudijskiprogramsemestar(Studijskiprogramsemestar studijskiprogramsemestar) {
        this.studijskiprogramsemestar = studijskiprogramsemestar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (predmetzaposleniPK != null ? predmetzaposleniPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Predmetzaposleni)) {
            return false;
        }
        Predmetzaposleni other = (Predmetzaposleni) object;
        if ((this.predmetzaposleniPK == null && other.predmetzaposleniPK != null) || (this.predmetzaposleniPK != null && !this.predmetzaposleniPK.equals(other.predmetzaposleniPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Predmetzaposleni[ predmetzaposleniPK=" + predmetzaposleniPK + " ]";
    }
    
}

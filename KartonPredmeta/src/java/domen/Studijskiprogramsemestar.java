/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sara
 */
@Entity
@Table(name = "studijskiprogramsemestar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studijskiprogramsemestar.findAll", query = "SELECT s FROM Studijskiprogramsemestar s")
    , @NamedQuery(name = "Studijskiprogramsemestar.findByPredmetID", query = "SELECT s FROM Studijskiprogramsemestar s WHERE s.studijskiprogramsemestarPK.predmetID = :predmetID")
    , @NamedQuery(name = "Studijskiprogramsemestar.findByStudijskiProgramID", query = "SELECT s FROM Studijskiprogramsemestar s WHERE s.studijskiprogramsemestarPK.studijskiProgramID = :studijskiProgramID")
    , @NamedQuery(name = "Studijskiprogramsemestar.findBySemestar", query = "SELECT s FROM Studijskiprogramsemestar s WHERE s.semestar = :semestar")})
public class Studijskiprogramsemestar implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudijskiprogramsemestarPK studijskiprogramsemestarPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "semestar")
    private int semestar;
    @JoinColumn(name = "predmetID", referencedColumnName = "predmetID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Predmet predmet;
    @JoinColumn(name = "studijskiProgramID", referencedColumnName = "studijskiProgramID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Studijskiprogram studijskiprogram;
    @OneToMany(mappedBy = "studijskiProgramPredmetID")
    private Collection<Predmetzaposleni> predmetzaposleniCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studijskiprogramsemestar")
    private Collection<Predmetzaposleni> predmetzaposleniCollection1;

    public Studijskiprogramsemestar() {
    }

    public Studijskiprogramsemestar(StudijskiprogramsemestarPK studijskiprogramsemestarPK) {
        this.studijskiprogramsemestarPK = studijskiprogramsemestarPK;
    }

    public Studijskiprogramsemestar(StudijskiprogramsemestarPK studijskiprogramsemestarPK, int semestar) {
        this.studijskiprogramsemestarPK = studijskiprogramsemestarPK;
        this.semestar = semestar;
    }

    public Studijskiprogramsemestar(int predmetID, int studijskiProgramID) {
        this.studijskiprogramsemestarPK = new StudijskiprogramsemestarPK(predmetID, studijskiProgramID);
    }

    public StudijskiprogramsemestarPK getStudijskiprogramsemestarPK() {
        return studijskiprogramsemestarPK;
    }

    public void setStudijskiprogramsemestarPK(StudijskiprogramsemestarPK studijskiprogramsemestarPK) {
        this.studijskiprogramsemestarPK = studijskiprogramsemestarPK;
    }

    public int getSemestar() {
        return semestar;
    }

    public void setSemestar(int semestar) {
        this.semestar = semestar;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public Studijskiprogram getStudijskiprogram() {
        return studijskiprogram;
    }

    public void setStudijskiprogram(Studijskiprogram studijskiprogram) {
        this.studijskiprogram = studijskiprogram;
    }

    @XmlTransient
    public Collection<Predmetzaposleni> getPredmetzaposleniCollection() {
        return predmetzaposleniCollection;
    }

    public void setPredmetzaposleniCollection(Collection<Predmetzaposleni> predmetzaposleniCollection) {
        this.predmetzaposleniCollection = predmetzaposleniCollection;
    }

    @XmlTransient
    public Collection<Predmetzaposleni> getPredmetzaposleniCollection1() {
        return predmetzaposleniCollection1;
    }

    public void setPredmetzaposleniCollection1(Collection<Predmetzaposleni> predmetzaposleniCollection1) {
        this.predmetzaposleniCollection1 = predmetzaposleniCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studijskiprogramsemestarPK != null ? studijskiprogramsemestarPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studijskiprogramsemestar)) {
            return false;
        }
        Studijskiprogramsemestar other = (Studijskiprogramsemestar) object;
        if ((this.studijskiprogramsemestarPK == null && other.studijskiprogramsemestarPK != null) || (this.studijskiprogramsemestarPK != null && !this.studijskiprogramsemestarPK.equals(other.studijskiprogramsemestarPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Studijskiprogramsemestar[ studijskiprogramsemestarPK=" + studijskiprogramsemestarPK + " ]";
    }
    
}

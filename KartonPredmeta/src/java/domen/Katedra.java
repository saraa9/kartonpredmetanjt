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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sara
 */
@Entity
@Table(name = "katedra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Katedra.findAll", query = "SELECT k FROM Katedra k")
    , @NamedQuery(name = "Katedra.findBySifraKatedre", query = "SELECT k FROM Katedra k WHERE k.sifraKatedre = :sifraKatedre")
    , @NamedQuery(name = "Katedra.findByNazivKatedre", query = "SELECT k FROM Katedra k WHERE k.nazivKatedre = :nazivKatedre")})
public class Katedra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sifraKatedre")
    private Integer sifraKatedre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nazivKatedre")
    private String nazivKatedre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sifraKatedre")
    private Collection<Zaposleni> zaposleniCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sifraKatedre")
    private Collection<Predmet> predmetCollection;

    public Katedra() {
    }

    public Katedra(Integer sifraKatedre) {
        this.sifraKatedre = sifraKatedre;
    }

    public Katedra(Integer sifraKatedre, String nazivKatedre) {
        this.sifraKatedre = sifraKatedre;
        this.nazivKatedre = nazivKatedre;
    }

    public Integer getSifraKatedre() {
        return sifraKatedre;
    }

    public void setSifraKatedre(Integer sifraKatedre) {
        this.sifraKatedre = sifraKatedre;
    }

    public String getNazivKatedre() {
        return nazivKatedre;
    }

    public void setNazivKatedre(String nazivKatedre) {
        this.nazivKatedre = nazivKatedre;
    }

    @XmlTransient
    public Collection<Zaposleni> getZaposleniCollection() {
        return zaposleniCollection;
    }

    public void setZaposleniCollection(Collection<Zaposleni> zaposleniCollection) {
        this.zaposleniCollection = zaposleniCollection;
    }

    @XmlTransient
    public Collection<Predmet> getPredmetCollection() {
        return predmetCollection;
    }

    public void setPredmetCollection(Collection<Predmet> predmetCollection) {
        this.predmetCollection = predmetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraKatedre != null ? sifraKatedre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Katedra)) {
            return false;
        }
        Katedra other = (Katedra) object;
        if ((this.sifraKatedre == null && other.sifraKatedre != null) || (this.sifraKatedre != null && !this.sifraKatedre.equals(other.sifraKatedre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Katedra[ sifraKatedre=" + sifraKatedre + " ]";
    }
    
}

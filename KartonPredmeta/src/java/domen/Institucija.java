/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "institucija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Institucija.findAll", query = "SELECT i FROM Institucija i")
    , @NamedQuery(name = "Institucija.findBySifraInstitucije", query = "SELECT i FROM Institucija i WHERE i.sifraInstitucije = :sifraInstitucije")
    , @NamedQuery(name = "Institucija.findByNazivInstitucije", query = "SELECT i FROM Institucija i WHERE i.nazivInstitucije = :nazivInstitucije")})
public class Institucija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sifraInstitucije")
    private Integer sifraInstitucije;
    @Size(max = 150)
    @Column(name = "nazivInstitucije")
    private String nazivInstitucije;

    public Institucija() {
    }

    public Institucija(Integer sifraInstitucije) {
        this.sifraInstitucije = sifraInstitucije;
    }

    public Integer getSifraInstitucije() {
        return sifraInstitucije;
    }

    public void setSifraInstitucije(Integer sifraInstitucije) {
        this.sifraInstitucije = sifraInstitucije;
    }

    public String getNazivInstitucije() {
        return nazivInstitucije;
    }

    public void setNazivInstitucije(String nazivInstitucije) {
        this.nazivInstitucije = nazivInstitucije;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraInstitucije != null ? sifraInstitucije.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institucija)) {
            return false;
        }
        Institucija other = (Institucija) object;
        if ((this.sifraInstitucije == null && other.sifraInstitucije != null) || (this.sifraInstitucije != null && !this.sifraInstitucije.equals(other.sifraInstitucije))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Institucija[ sifraInstitucije=" + sifraInstitucije + " ]";
    }
    
}

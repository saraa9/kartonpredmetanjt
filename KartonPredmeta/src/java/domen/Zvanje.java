/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sara
 */
@Entity
@Table(name = "zvanje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zvanje.findAll", query = "SELECT z FROM Zvanje z")
    , @NamedQuery(name = "Zvanje.findByZvanjeID", query = "SELECT z FROM Zvanje z WHERE z.zvanjeID = :zvanjeID")
    , @NamedQuery(name = "Zvanje.findByNazivZvanja", query = "SELECT z FROM Zvanje z WHERE z.nazivZvanja = :nazivZvanja")})
public class Zvanje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zvanjeID")
    private Integer zvanjeID;
    @Size(max = 100)
    @Column(name = "nazivZvanja")
    private String nazivZvanja;
    @OneToMany(mappedBy = "zvanjeID")
    private Collection<Zaposleni> zaposleniCollection;

    public Zvanje() {
    }

    public Zvanje(Integer zvanjeID) {
        this.zvanjeID = zvanjeID;
    }

    public Integer getZvanjeID() {
        return zvanjeID;
    }

    public void setZvanjeID(Integer zvanjeID) {
        this.zvanjeID = zvanjeID;
    }

    public String getNazivZvanja() {
        return nazivZvanja;
    }

    public void setNazivZvanja(String nazivZvanja) {
        this.nazivZvanja = nazivZvanja;
    }

    @XmlTransient
    public Collection<Zaposleni> getZaposleniCollection() {
        return zaposleniCollection;
    }

    public void setZaposleniCollection(Collection<Zaposleni> zaposleniCollection) {
        this.zaposleniCollection = zaposleniCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zvanjeID != null ? zvanjeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zvanje)) {
            return false;
        }
        Zvanje other = (Zvanje) object;
        if ((this.zvanjeID == null && other.zvanjeID != null) || (this.zvanjeID != null && !this.zvanjeID.equals(other.zvanjeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Zvanje[ zvanjeID=" + zvanjeID + " ]";
    }
    
}

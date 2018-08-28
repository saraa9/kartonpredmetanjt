/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sara
 */
@Entity
@Table(name = "zaposleni")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zaposleni.findAll", query = "SELECT z FROM Zaposleni z")
    , @NamedQuery(name = "Zaposleni.findByZaposleniID", query = "SELECT z FROM Zaposleni z WHERE z.zaposleniID = :zaposleniID")
    , @NamedQuery(name = "Zaposleni.findByIme", query = "SELECT z FROM Zaposleni z WHERE z.ime = :ime")
    , @NamedQuery(name = "Zaposleni.findByPrezime", query = "SELECT z FROM Zaposleni z WHERE z.prezime = :prezime")
    , @NamedQuery(name = "Zaposleni.findByTitula", query = "SELECT z FROM Zaposleni z WHERE z.titula = :titula")
    , @NamedQuery(name = "Zaposleni.findByDatumRodjenja", query = "SELECT z FROM Zaposleni z WHERE z.datumRodjenja = :datumRodjenja")})
public class Zaposleni implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zaposleniID")
    private Integer zaposleniID;
    @Size(max = 50)
    @Column(name = "ime")
    private String ime;
    @Size(max = 50)
    @Column(name = "prezime")
    private String prezime;
    @Size(max = 50)
    @Column(name = "titula")
    private String titula;
    @Column(name = "datumRodjenja")
    @Temporal(TemporalType.DATE)
    private Date datumRodjenja;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zaposleni")
    private Collection<Predmetzaposleni> predmetzaposleniCollection;
    @JoinColumn(name = "sifraKatedre", referencedColumnName = "sifraKatedre")
    @ManyToOne(optional = false)
    private Katedra sifraKatedre;
    @JoinColumn(name = "zvanjeID", referencedColumnName = "zvanjeID")
    @ManyToOne
    private Zvanje zvanjeID;

    public Zaposleni() {
    }

    public Zaposleni(Integer zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    public Integer getZaposleniID() {
        return zaposleniID;
    }

    public void setZaposleniID(Integer zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    @XmlTransient
    public Collection<Predmetzaposleni> getPredmetzaposleniCollection() {
        return predmetzaposleniCollection;
    }

    public void setPredmetzaposleniCollection(Collection<Predmetzaposleni> predmetzaposleniCollection) {
        this.predmetzaposleniCollection = predmetzaposleniCollection;
    }

    public Katedra getSifraKatedre() {
        return sifraKatedre;
    }

    public void setSifraKatedre(Katedra sifraKatedre) {
        this.sifraKatedre = sifraKatedre;
    }

    public Zvanje getZvanjeID() {
        return zvanjeID;
    }

    public void setZvanjeID(Zvanje zvanjeID) {
        this.zvanjeID = zvanjeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zaposleniID != null ? zaposleniID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zaposleni)) {
            return false;
        }
        Zaposleni other = (Zaposleni) object;
        if ((this.zaposleniID == null && other.zaposleniID != null) || (this.zaposleniID != null && !this.zaposleniID.equals(other.zaposleniID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Zaposleni[ zaposleniID=" + zaposleniID + " ]";
    }
    
}

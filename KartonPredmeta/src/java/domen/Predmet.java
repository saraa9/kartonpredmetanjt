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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "predmet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Predmet.findAll", query = "SELECT p FROM Predmet p")
    , @NamedQuery(name = "Predmet.findByPredmetID", query = "SELECT p FROM Predmet p WHERE p.predmetID = :predmetID")
    , @NamedQuery(name = "Predmet.findByNazivPredmeta", query = "SELECT p FROM Predmet p WHERE p.nazivPredmeta = :nazivPredmeta")
    , @NamedQuery(name = "Predmet.findByBrojESPB", query = "SELECT p FROM Predmet p WHERE p.brojESPB = :brojESPB")})
public class Predmet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "predmetID")
    private Integer predmetID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nazivPredmeta")
    private String nazivPredmeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "brojESPB")
    private int brojESPB;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "predmetID")
    private Collection<Kartonpredmeta> kartonpredmetaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "predmet")
    private Collection<Studijskiprogramsemestar> studijskiprogramsemestarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "predmet")
    private Collection<Predmetzaposleni> predmetzaposleniCollection;
    @JoinColumn(name = "sifraKatedre", referencedColumnName = "sifraKatedre")
    @ManyToOne(optional = false)
    private Katedra sifraKatedre;

    public Predmet() {
    }

    public Predmet(Integer predmetID) {
        this.predmetID = predmetID;
    }

    public Predmet(Integer predmetID, String nazivPredmeta, int brojESPB) {
        this.predmetID = predmetID;
        this.nazivPredmeta = nazivPredmeta;
        this.brojESPB = brojESPB;
    }

    public Integer getPredmetID() {
        return predmetID;
    }

    public void setPredmetID(Integer predmetID) {
        this.predmetID = predmetID;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public int getBrojESPB() {
        return brojESPB;
    }

    public void setBrojESPB(int brojESPB) {
        this.brojESPB = brojESPB;
    }

    @XmlTransient
    public Collection<Kartonpredmeta> getKartonpredmetaCollection() {
        return kartonpredmetaCollection;
    }

    public void setKartonpredmetaCollection(Collection<Kartonpredmeta> kartonpredmetaCollection) {
        this.kartonpredmetaCollection = kartonpredmetaCollection;
    }

    @XmlTransient
    public Collection<Studijskiprogramsemestar> getStudijskiprogramsemestarCollection() {
        return studijskiprogramsemestarCollection;
    }

    public void setStudijskiprogramsemestarCollection(Collection<Studijskiprogramsemestar> studijskiprogramsemestarCollection) {
        this.studijskiprogramsemestarCollection = studijskiprogramsemestarCollection;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (predmetID != null ? predmetID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Predmet)) {
            return false;
        }
        Predmet other = (Predmet) object;
        if ((this.predmetID == null && other.predmetID != null) || (this.predmetID != null && !this.predmetID.equals(other.predmetID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Predmet[ predmetID=" + predmetID + " ]";
    }
    
}

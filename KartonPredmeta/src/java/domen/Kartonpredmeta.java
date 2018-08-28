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
@Table(name = "kartonpredmeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kartonpredmeta.findAll", query = "SELECT k FROM Kartonpredmeta k")
    , @NamedQuery(name = "Kartonpredmeta.findByKartonPredmetaID", query = "SELECT k FROM Kartonpredmeta k WHERE k.kartonPredmetaID = :kartonPredmetaID")
    , @NamedQuery(name = "Kartonpredmeta.findByCilj", query = "SELECT k FROM Kartonpredmeta k WHERE k.cilj = :cilj")
    , @NamedQuery(name = "Kartonpredmeta.findByIshod", query = "SELECT k FROM Kartonpredmeta k WHERE k.ishod = :ishod")
    , @NamedQuery(name = "Kartonpredmeta.findBySadrzaj", query = "SELECT k FROM Kartonpredmeta k WHERE k.sadrzaj = :sadrzaj")})
public class Kartonpredmeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kartonPredmetaID")
    private Integer kartonPredmetaID;
    @Size(max = 10000)
    @Column(name = "cilj")
    private String cilj;
    @Size(max = 10000)
    @Column(name = "ishod")
    private String ishod;
    @Size(max = 10000)
    @Column(name = "sadrzaj")
    private String sadrzaj;
    @JoinColumn(name = "predmetID", referencedColumnName = "predmetID")
    @ManyToOne(optional = false)
    private Predmet predmetID;

    public Kartonpredmeta() {
    }

    public Kartonpredmeta(Integer kartonPredmetaID) {
        this.kartonPredmetaID = kartonPredmetaID;
    }

    public Integer getKartonPredmetaID() {
        return kartonPredmetaID;
    }

    public void setKartonPredmetaID(Integer kartonPredmetaID) {
        this.kartonPredmetaID = kartonPredmetaID;
    }

    public String getCilj() {
        return cilj;
    }

    public void setCilj(String cilj) {
        this.cilj = cilj;
    }

    public String getIshod() {
        return ishod;
    }

    public void setIshod(String ishod) {
        this.ishod = ishod;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public Predmet getPredmetID() {
        return predmetID;
    }

    public void setPredmetID(Predmet predmetID) {
        this.predmetID = predmetID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kartonPredmetaID != null ? kartonPredmetaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kartonpredmeta)) {
            return false;
        }
        Kartonpredmeta other = (Kartonpredmeta) object;
        if ((this.kartonPredmetaID == null && other.kartonPredmetaID != null) || (this.kartonPredmetaID != null && !this.kartonPredmetaID.equals(other.kartonPredmetaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Kartonpredmeta[ kartonPredmetaID=" + kartonPredmetaID + " ]";
    }
    
}

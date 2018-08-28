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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sara
 */
@Entity
@Table(name = "studijskiprogram")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studijskiprogram.findAll", query = "SELECT s FROM Studijskiprogram s")
    , @NamedQuery(name = "Studijskiprogram.findByStudijskiProgramID", query = "SELECT s FROM Studijskiprogram s WHERE s.studijskiProgramID = :studijskiProgramID")
    , @NamedQuery(name = "Studijskiprogram.findByNazivStudijskogPrograma", query = "SELECT s FROM Studijskiprogram s WHERE s.nazivStudijskogPrograma = :nazivStudijskogPrograma")})
public class Studijskiprogram implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "studijskiProgramID")
    private Integer studijskiProgramID;
    @Size(max = 50)
    @Column(name = "nazivStudijskogPrograma")
    private String nazivStudijskogPrograma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studijskiprogram")
    private Collection<Studijskiprogramsemestar> studijskiprogramsemestarCollection;

    public Studijskiprogram() {
    }

    public Studijskiprogram(Integer studijskiProgramID) {
        this.studijskiProgramID = studijskiProgramID;
    }

    public Integer getStudijskiProgramID() {
        return studijskiProgramID;
    }

    public void setStudijskiProgramID(Integer studijskiProgramID) {
        this.studijskiProgramID = studijskiProgramID;
    }

    public String getNazivStudijskogPrograma() {
        return nazivStudijskogPrograma;
    }

    public void setNazivStudijskogPrograma(String nazivStudijskogPrograma) {
        this.nazivStudijskogPrograma = nazivStudijskogPrograma;
    }

    @XmlTransient
    public Collection<Studijskiprogramsemestar> getStudijskiprogramsemestarCollection() {
        return studijskiprogramsemestarCollection;
    }

    public void setStudijskiprogramsemestarCollection(Collection<Studijskiprogramsemestar> studijskiprogramsemestarCollection) {
        this.studijskiprogramsemestarCollection = studijskiprogramsemestarCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studijskiProgramID != null ? studijskiProgramID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studijskiprogram)) {
            return false;
        }
        Studijskiprogram other = (Studijskiprogram) object;
        if ((this.studijskiProgramID == null && other.studijskiProgramID != null) || (this.studijskiProgramID != null && !this.studijskiProgramID.equals(other.studijskiProgramID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Studijskiprogram[ studijskiProgramID=" + studijskiProgramID + " ]";
    }
    
}

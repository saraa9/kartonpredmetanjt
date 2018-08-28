/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sara
 */
@Embeddable
public class PredmetzaposleniPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "predmetID")
    private int predmetID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zaposleniID")
    private int zaposleniID;

    public PredmetzaposleniPK() {
    }

    public PredmetzaposleniPK(int predmetID, int zaposleniID) {
        this.predmetID = predmetID;
        this.zaposleniID = zaposleniID;
    }

    public int getPredmetID() {
        return predmetID;
    }

    public void setPredmetID(int predmetID) {
        this.predmetID = predmetID;
    }

    public int getZaposleniID() {
        return zaposleniID;
    }

    public void setZaposleniID(int zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) predmetID;
        hash += (int) zaposleniID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PredmetzaposleniPK)) {
            return false;
        }
        PredmetzaposleniPK other = (PredmetzaposleniPK) object;
        if (this.predmetID != other.predmetID) {
            return false;
        }
        if (this.zaposleniID != other.zaposleniID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.PredmetzaposleniPK[ predmetID=" + predmetID + ", zaposleniID=" + zaposleniID + " ]";
    }
    
}

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
public class StudijskiprogramsemestarPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "predmetID")
    private int predmetID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "studijskiProgramID")
    private int studijskiProgramID;

    public StudijskiprogramsemestarPK() {
    }

    public StudijskiprogramsemestarPK(int predmetID, int studijskiProgramID) {
        this.predmetID = predmetID;
        this.studijskiProgramID = studijskiProgramID;
    }

    public int getPredmetID() {
        return predmetID;
    }

    public void setPredmetID(int predmetID) {
        this.predmetID = predmetID;
    }

    public int getStudijskiProgramID() {
        return studijskiProgramID;
    }

    public void setStudijskiProgramID(int studijskiProgramID) {
        this.studijskiProgramID = studijskiProgramID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) predmetID;
        hash += (int) studijskiProgramID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudijskiprogramsemestarPK)) {
            return false;
        }
        StudijskiprogramsemestarPK other = (StudijskiprogramsemestarPK) object;
        if (this.predmetID != other.predmetID) {
            return false;
        }
        if (this.studijskiProgramID != other.studijskiProgramID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.StudijskiprogramsemestarPK[ predmetID=" + predmetID + ", studijskiProgramID=" + studijskiProgramID + " ]";
    }
    
}

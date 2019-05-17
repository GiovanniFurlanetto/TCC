/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author furlanetto
 */
@Embeddable
public class RecebimentoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idOS")
    private int idOS;
    @Basic(optional = false)
    @Column(name = "nr_parcela")
    private int nrParcela;

    public RecebimentoPK() {
    }

    public RecebimentoPK(int idOS, int nrParcela) {
        this.idOS = idOS;
        this.nrParcela = nrParcela;
    }

    public int getIdOS() {
        return idOS;
    }

    public void setIdOS(int idOS) {
        this.idOS = idOS;
    }

    public int getNrParcela() {
        return nrParcela;
    }

    public void setNrParcela(int nrParcela) {
        this.nrParcela = nrParcela;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOS;
        hash += (int) nrParcela;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecebimentoPK)) {
            return false;
        }
        RecebimentoPK other = (RecebimentoPK) object;
        if (this.idOS != other.idOS) {
            return false;
        }
        if (this.nrParcela != other.nrParcela) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.RecebimentoPK[ idOS=" + idOS + ", nrParcela=" + nrParcela + " ]";
    }
    
}

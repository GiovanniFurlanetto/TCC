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
public class PecaUtilizadaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "OS_idOS")
    private int oSidOS;
    @Basic(optional = false)
    @Column(name = "Pe\u00e7a_idPe\u00e7a")
    private int peçaidPeça;

    public PecaUtilizadaPK() {
    }

    public PecaUtilizadaPK(int oSidOS, int peçaidPeça) {
        this.oSidOS = oSidOS;
        this.peçaidPeça = peçaidPeça;
    }

    public int getOSidOS() {
        return oSidOS;
    }

    public void setOSidOS(int oSidOS) {
        this.oSidOS = oSidOS;
    }

    public int getPeçaidPeça() {
        return peçaidPeça;
    }

    public void setPeçaidPeça(int peçaidPeça) {
        this.peçaidPeça = peçaidPeça;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) oSidOS;
        hash += (int) peçaidPeça;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PecaUtilizadaPK)) {
            return false;
        }
        PecaUtilizadaPK other = (PecaUtilizadaPK) object;
        if (this.oSidOS != other.oSidOS) {
            return false;
        }
        if (this.peçaidPeça != other.peçaidPeça) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PecaUtilizadaPK[ oSidOS=" + oSidOS + ", pe\u00e7aidPe\u00e7a=" + peçaidPeça + " ]";
    }
    
}

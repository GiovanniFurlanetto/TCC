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
public class ServicoOsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Servi\u00e7o_idServi\u00e7o")
    private int serviçoidServiço;
    @Basic(optional = false)
    @Column(name = "OS_idOS")
    private int oSidOS;

    public ServicoOsPK() {
    }

    public ServicoOsPK(int serviçoidServiço, int oSidOS) {
        this.serviçoidServiço = serviçoidServiço;
        this.oSidOS = oSidOS;
    }

    public int getServiçoidServiço() {
        return serviçoidServiço;
    }

    public void setServiçoidServiço(int serviçoidServiço) {
        this.serviçoidServiço = serviçoidServiço;
    }

    public int getOSidOS() {
        return oSidOS;
    }

    public void setOSidOS(int oSidOS) {
        this.oSidOS = oSidOS;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) serviçoidServiço;
        hash += (int) oSidOS;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicoOsPK)) {
            return false;
        }
        ServicoOsPK other = (ServicoOsPK) object;
        if (this.serviçoidServiço != other.serviçoidServiço) {
            return false;
        }
        if (this.oSidOS != other.oSidOS) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ServicoOsPK[ servi\u00e7oidServi\u00e7o=" + serviçoidServiço + ", oSidOS=" + oSidOS + " ]";
    }
    
}

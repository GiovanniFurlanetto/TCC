/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author furlanetto
 */
@Entity
@Table(name = "servico_os")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicoOs.findAll", query = "SELECT s FROM ServicoOs s"),
    @NamedQuery(name = "ServicoOs.findByServi\u00e7oidServi\u00e7o", query = "SELECT s FROM ServicoOs s WHERE s.servicoOsPK.servi\u00e7oidServi\u00e7o = :servi\u00e7oidServi\u00e7o"),
    @NamedQuery(name = "ServicoOs.findByOSidOS", query = "SELECT s FROM ServicoOs s WHERE s.servicoOsPK.oSidOS = :oSidOS"),
    @NamedQuery(name = "ServicoOs.findByValor", query = "SELECT s FROM ServicoOs s WHERE s.valor = :valor"),
    @NamedQuery(name = "ServicoOs.findByQuantidade", query = "SELECT s FROM ServicoOs s WHERE s.quantidade = :quantidade"),
    @NamedQuery(name = "ServicoOs.findByStatus", query = "SELECT s FROM ServicoOs s WHERE s.status = :status")})
public class ServicoOs implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ServicoOsPK servicoOsPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "OS_idOS", referencedColumnName = "idOS", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Os os;
    @JoinColumn(name = "Servi\u00e7o_idServi\u00e7o", referencedColumnName = "idServi\u00e7o", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Serviço serviço;

    public ServicoOs() {
    }

    public ServicoOs(ServicoOsPK servicoOsPK) {
        this.servicoOsPK = servicoOsPK;
    }

    public ServicoOs(int serviçoidServiço, int oSidOS) {
        this.servicoOsPK = new ServicoOsPK(serviçoidServiço, oSidOS);
    }

    public ServicoOsPK getServicoOsPK() {
        return servicoOsPK;
    }

    public void setServicoOsPK(ServicoOsPK servicoOsPK) {
        this.servicoOsPK = servicoOsPK;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Os getOs() {
        return os;
    }

    public void setOs(Os os) {
        this.os = os;
    }

    public Serviço getServiço() {
        return serviço;
    }

    public void setServiço(Serviço serviço) {
        this.serviço = serviço;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicoOsPK != null ? servicoOsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicoOs)) {
            return false;
        }
        ServicoOs other = (ServicoOs) object;
        if ((this.servicoOsPK == null && other.servicoOsPK != null) || (this.servicoOsPK != null && !this.servicoOsPK.equals(other.servicoOsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ServicoOs[ servicoOsPK=" + servicoOsPK + " ]";
    }
    
}

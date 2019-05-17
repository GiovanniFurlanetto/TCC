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
@Table(name = "peca_utilizada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PecaUtilizada.findAll", query = "SELECT p FROM PecaUtilizada p"),
    @NamedQuery(name = "PecaUtilizada.findByOSidOS", query = "SELECT p FROM PecaUtilizada p WHERE p.pecaUtilizadaPK.oSidOS = :oSidOS"),
    @NamedQuery(name = "PecaUtilizada.findByPe\u00e7aidPe\u00e7a", query = "SELECT p FROM PecaUtilizada p WHERE p.pecaUtilizadaPK.pe\u00e7aidPe\u00e7a = :pe\u00e7aidPe\u00e7a"),
    @NamedQuery(name = "PecaUtilizada.findByQuantidade", query = "SELECT p FROM PecaUtilizada p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "PecaUtilizada.findByValor", query = "SELECT p FROM PecaUtilizada p WHERE p.valor = :valor"),
    @NamedQuery(name = "PecaUtilizada.findByStatus", query = "SELECT p FROM PecaUtilizada p WHERE p.status = :status")})
public class PecaUtilizada implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PecaUtilizadaPK pecaUtilizadaPK;
    @Column(name = "Quantidade")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "OS_idOS", referencedColumnName = "idOS", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Os os;
    @JoinColumn(name = "Pe\u00e7a_idPe\u00e7a", referencedColumnName = "idPe\u00e7a", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Peça peça;

    public PecaUtilizada() {
    }

    public PecaUtilizada(PecaUtilizadaPK pecaUtilizadaPK) {
        this.pecaUtilizadaPK = pecaUtilizadaPK;
    }

    public PecaUtilizada(int oSidOS, int peçaidPeça) {
        this.pecaUtilizadaPK = new PecaUtilizadaPK(oSidOS, peçaidPeça);
    }

    public PecaUtilizadaPK getPecaUtilizadaPK() {
        return pecaUtilizadaPK;
    }

    public void setPecaUtilizadaPK(PecaUtilizadaPK pecaUtilizadaPK) {
        this.pecaUtilizadaPK = pecaUtilizadaPK;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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

    public Peça getPeça() {
        return peça;
    }

    public void setPeça(Peça peça) {
        this.peça = peça;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pecaUtilizadaPK != null ? pecaUtilizadaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PecaUtilizada)) {
            return false;
        }
        PecaUtilizada other = (PecaUtilizada) object;
        if ((this.pecaUtilizadaPK == null && other.pecaUtilizadaPK != null) || (this.pecaUtilizadaPK != null && !this.pecaUtilizadaPK.equals(other.pecaUtilizadaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PecaUtilizada[ pecaUtilizadaPK=" + pecaUtilizadaPK + " ]";
    }
    
}

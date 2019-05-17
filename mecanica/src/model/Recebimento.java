/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author furlanetto
 */
@Entity
@Table(name = "Recebimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recebimento.findAll", query = "SELECT r FROM Recebimento r"),
    @NamedQuery(name = "Recebimento.findByIdOS", query = "SELECT r FROM Recebimento r WHERE r.recebimentoPK.idOS = :idOS"),
    @NamedQuery(name = "Recebimento.findByNrParcela", query = "SELECT r FROM Recebimento r WHERE r.recebimentoPK.nrParcela = :nrParcela"),
    @NamedQuery(name = "Recebimento.findByValor", query = "SELECT r FROM Recebimento r WHERE r.valor = :valor"),
    @NamedQuery(name = "Recebimento.findByDataVencimento", query = "SELECT r FROM Recebimento r WHERE r.dataVencimento = :dataVencimento"),
    @NamedQuery(name = "Recebimento.findByDataPagamento", query = "SELECT r FROM Recebimento r WHERE r.dataPagamento = :dataPagamento"),
    @NamedQuery(name = "Recebimento.findByValorPago", query = "SELECT r FROM Recebimento r WHERE r.valorPago = :valorPago"),
    @NamedQuery(name = "Recebimento.findByObservacao", query = "SELECT r FROM Recebimento r WHERE r.observacao = :observacao")})
public class Recebimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecebimentoPK recebimentoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Valor")
    private Double valor;
    @Column(name = "data_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Column(name = "data_pagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    @Column(name = "valor_pago")
    private Double valorPago;
    @Column(name = "observacao")
    private String observacao;
    @JoinColumn(name = "idOS", referencedColumnName = "idOS", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Os os;

    public Recebimento() {
    }

    public Recebimento(RecebimentoPK recebimentoPK) {
        this.recebimentoPK = recebimentoPK;
    }

    public Recebimento(int idOS, int nrParcela) {
        this.recebimentoPK = new RecebimentoPK(idOS, nrParcela);
    }

    public RecebimentoPK getRecebimentoPK() {
        return recebimentoPK;
    }

    public void setRecebimentoPK(RecebimentoPK recebimentoPK) {
        this.recebimentoPK = recebimentoPK;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Os getOs() {
        return os;
    }

    public void setOs(Os os) {
        this.os = os;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recebimentoPK != null ? recebimentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recebimento)) {
            return false;
        }
        Recebimento other = (Recebimento) object;
        if ((this.recebimentoPK == null && other.recebimentoPK != null) || (this.recebimentoPK != null && !this.recebimentoPK.equals(other.recebimentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Recebimento[ recebimentoPK=" + recebimentoPK + " ]";
    }
    
}

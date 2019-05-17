/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author furlanetto
 */
@Entity
@Table(name = "compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByNumeroNf", query = "SELECT c FROM Compra c WHERE c.compraPK.numeroNf = :numeroNf"),
    @NamedQuery(name = "Compra.findByData", query = "SELECT c FROM Compra c WHERE c.data = :data"),
    @NamedQuery(name = "Compra.findByValor", query = "SELECT c FROM Compra c WHERE c.valor = :valor"),
    @NamedQuery(name = "Compra.findByFormaPagamento", query = "SELECT c FROM Compra c WHERE c.formaPagamento = :formaPagamento"),
    @NamedQuery(name = "Compra.findByFornecedoridFornecedor", query = "SELECT c FROM Compra c WHERE c.compraPK.fornecedoridFornecedor = :fornecedoridFornecedor")})
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CompraPK compraPK;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Column(name = "forma_pagamento")
    private String formaPagamento;
    @JoinColumn(name = "Fornecedor_idFornecedor", referencedColumnName = "idFornecedor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fornecedor fornecedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compra")
    private Collection<PecaComprada> pecaCompradaCollection;
    @OneToMany(mappedBy = "compra")
    private Collection<Despesa> despesaCollection;

    public Compra() {
    }

    public Compra(CompraPK compraPK) {
        this.compraPK = compraPK;
    }

    public Compra(int numeroNf, int fornecedoridFornecedor) {
        this.compraPK = new CompraPK(numeroNf, fornecedoridFornecedor);
    }

    public CompraPK getCompraPK() {
        return compraPK;
    }

    public void setCompraPK(CompraPK compraPK) {
        this.compraPK = compraPK;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @XmlTransient
    public Collection<PecaComprada> getPecaCompradaCollection() {
        return pecaCompradaCollection;
    }

    public void setPecaCompradaCollection(Collection<PecaComprada> pecaCompradaCollection) {
        this.pecaCompradaCollection = pecaCompradaCollection;
    }

    @XmlTransient
    public Collection<Despesa> getDespesaCollection() {
        return despesaCollection;
    }

    public void setDespesaCollection(Collection<Despesa> despesaCollection) {
        this.despesaCollection = despesaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compraPK != null ? compraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.compraPK == null && other.compraPK != null) || (this.compraPK != null && !this.compraPK.equals(other.compraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Compra[ compraPK=" + compraPK + " ]";
    }
    
}

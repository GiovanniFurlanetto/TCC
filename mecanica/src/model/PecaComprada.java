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
import javax.persistence.JoinColumns;
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
@Table(name = "peca_comprada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PecaComprada.findAll", query = "SELECT p FROM PecaComprada p"),
    @NamedQuery(name = "PecaComprada.findByCompraNumeroNf", query = "SELECT p FROM PecaComprada p WHERE p.pecaCompradaPK.compraNumeroNf = :compraNumeroNf"),
    @NamedQuery(name = "PecaComprada.findByCompraFornecedoridFornecedor", query = "SELECT p FROM PecaComprada p WHERE p.pecaCompradaPK.compraFornecedoridFornecedor = :compraFornecedoridFornecedor"),
    @NamedQuery(name = "PecaComprada.findByPe\u00e7aidPe\u00e7a", query = "SELECT p FROM PecaComprada p WHERE p.pecaCompradaPK.pe\u00e7aidPe\u00e7a = :pe\u00e7aidPe\u00e7a"),
    @NamedQuery(name = "PecaComprada.findByQuantidade", query = "SELECT p FROM PecaComprada p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "PecaComprada.findByValor", query = "SELECT p FROM PecaComprada p WHERE p.valor = :valor")})
public class PecaComprada implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PecaCompradaPK pecaCompradaPK;
    @Column(name = "quantidade")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @JoinColumn(name = "Pe\u00e7a_idPe\u00e7a", referencedColumnName = "idPe\u00e7a", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Peça peça;
    @JoinColumns({
        @JoinColumn(name = "compra_numero_nf", referencedColumnName = "numero_nf", insertable = false, updatable = false),
        @JoinColumn(name = "compra_Fornecedor_idFornecedor", referencedColumnName = "Fornecedor_idFornecedor", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Compra compra;

    public PecaComprada() {
    }

    public PecaComprada(PecaCompradaPK pecaCompradaPK) {
        this.pecaCompradaPK = pecaCompradaPK;
    }

    public PecaComprada(int compraNumeroNf, int compraFornecedoridFornecedor, int peçaidPeça) {
        this.pecaCompradaPK = new PecaCompradaPK(compraNumeroNf, compraFornecedoridFornecedor, peçaidPeça);
    }

    public PecaCompradaPK getPecaCompradaPK() {
        return pecaCompradaPK;
    }

    public void setPecaCompradaPK(PecaCompradaPK pecaCompradaPK) {
        this.pecaCompradaPK = pecaCompradaPK;
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

    public Peça getPeça() {
        return peça;
    }

    public void setPeça(Peça peça) {
        this.peça = peça;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pecaCompradaPK != null ? pecaCompradaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PecaComprada)) {
            return false;
        }
        PecaComprada other = (PecaComprada) object;
        if ((this.pecaCompradaPK == null && other.pecaCompradaPK != null) || (this.pecaCompradaPK != null && !this.pecaCompradaPK.equals(other.pecaCompradaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PecaComprada[ pecaCompradaPK=" + pecaCompradaPK + " ]";
    }
    
}

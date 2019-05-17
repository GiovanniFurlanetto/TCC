/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "Despesa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Despesa.findAll", query = "SELECT d FROM Despesa d"),
    @NamedQuery(name = "Despesa.findByIdDespesa", query = "SELECT d FROM Despesa d WHERE d.idDespesa = :idDespesa"),
    @NamedQuery(name = "Despesa.findByDescricao", query = "SELECT d FROM Despesa d WHERE d.descricao = :descricao"),
    @NamedQuery(name = "Despesa.findByValor", query = "SELECT d FROM Despesa d WHERE d.valor = :valor"),
    @NamedQuery(name = "Despesa.findByDatavencimento", query = "SELECT d FROM Despesa d WHERE d.datavencimento = :datavencimento")})
public class Despesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idDespesa")
    private Integer idDespesa;
    @Column(name = "Descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Valor")
    private Double valor;
    @Column(name = "Data_vencimento")
    @Temporal(TemporalType.DATE)
    private Date datavencimento;
    @JoinColumns({
        @JoinColumn(name = "compra_numero_nf", referencedColumnName = "numero_nf"),
        @JoinColumn(name = "compra_Fornecedor_idFornecedor", referencedColumnName = "Fornecedor_idFornecedor")})
    @ManyToOne
    private Compra compra;

    public Despesa() {
    }

    public Despesa(Integer idDespesa) {
        this.idDespesa = idDespesa;
    }

    public Integer getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(Integer idDespesa) {
        this.idDespesa = idDespesa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDatavencimento() {
        return datavencimento;
    }

    public void setDatavencimento(Date datavencimento) {
        this.datavencimento = datavencimento;
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
        hash += (idDespesa != null ? idDespesa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Despesa)) {
            return false;
        }
        Despesa other = (Despesa) object;
        if ((this.idDespesa == null && other.idDespesa != null) || (this.idDespesa != null && !this.idDespesa.equals(other.idDespesa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Despesa[ idDespesa=" + idDespesa + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "Pe\u00e7a")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pe\u00e7a.findAll", query = "SELECT p FROM Pe\u00e7a p"),
    @NamedQuery(name = "Pe\u00e7a.findByIdPe\u00e7a", query = "SELECT p FROM Pe\u00e7a p WHERE p.idPe\u00e7a = :idPe\u00e7a"),
    @NamedQuery(name = "Pe\u00e7a.findByNome", query = "SELECT p FROM Pe\u00e7a p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pe\u00e7a.findByValor", query = "SELECT p FROM Pe\u00e7a p WHERE p.valor = :valor"),
    @NamedQuery(name = "Pe\u00e7a.findByDataultimaatualizacao", query = "SELECT p FROM Pe\u00e7a p WHERE p.dataultimaatualizacao = :dataultimaatualizacao"),
    @NamedQuery(name = "Pe\u00e7a.findByQuantidade", query = "SELECT p FROM Pe\u00e7a p WHERE p.quantidade = :quantidade")})
public class Peça implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPe\u00e7a")
    private Integer idPeça;
    @Column(name = "Nome")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Valor")
    private Double valor;
    @Column(name = "Data_ultima_atualizacao")
    @Temporal(TemporalType.DATE)
    private Date dataultimaatualizacao;
    @Column(name = "quantidade")
    private Integer quantidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pe\u00e7a")
    private Collection<PecaUtilizada> pecaUtilizadaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pe\u00e7a")
    private Collection<Pedido> pedidoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pe\u00e7a")
    private Collection<PecaComprada> pecaCompradaCollection;

    public Peça() {
    }

    public Peça(Integer idPeça) {
        this.idPeça = idPeça;
    }

    public Integer getIdPeça() {
        return idPeça;
    }

    public void setIdPeça(Integer idPeça) {
        this.idPeça = idPeça;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataultimaatualizacao() {
        return dataultimaatualizacao;
    }

    public void setDataultimaatualizacao(Date dataultimaatualizacao) {
        this.dataultimaatualizacao = dataultimaatualizacao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @XmlTransient
    public Collection<PecaUtilizada> getPecaUtilizadaCollection() {
        return pecaUtilizadaCollection;
    }

    public void setPecaUtilizadaCollection(Collection<PecaUtilizada> pecaUtilizadaCollection) {
        this.pecaUtilizadaCollection = pecaUtilizadaCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @XmlTransient
    public Collection<PecaComprada> getPecaCompradaCollection() {
        return pecaCompradaCollection;
    }

    public void setPecaCompradaCollection(Collection<PecaComprada> pecaCompradaCollection) {
        this.pecaCompradaCollection = pecaCompradaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeça != null ? idPeça.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peça)) {
            return false;
        }
        Peça other = (Peça) object;
        if ((this.idPeça == null && other.idPeça != null) || (this.idPeça != null && !this.idPeça.equals(other.idPeça))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pe\u00e7a[ idPe\u00e7a=" + idPeça + " ]";
    }
    
}

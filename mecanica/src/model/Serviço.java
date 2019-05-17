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
@Table(name = "Servi\u00e7o")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servi\u00e7o.findAll", query = "SELECT s FROM Servi\u00e7o s"),
    @NamedQuery(name = "Servi\u00e7o.findByIdServi\u00e7o", query = "SELECT s FROM Servi\u00e7o s WHERE s.idServi\u00e7o = :idServi\u00e7o"),
    @NamedQuery(name = "Servi\u00e7o.findByNome", query = "SELECT s FROM Servi\u00e7o s WHERE s.nome = :nome"),
    @NamedQuery(name = "Servi\u00e7o.findByValor", query = "SELECT s FROM Servi\u00e7o s WHERE s.valor = :valor"),
    @NamedQuery(name = "Servi\u00e7o.findByDataultimaatualizacao", query = "SELECT s FROM Servi\u00e7o s WHERE s.dataultimaatualizacao = :dataultimaatualizacao")})
public class Serviço implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idServi\u00e7o")
    private Integer idServiço;
    @Column(name = "Nome")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Valor")
    private Double valor;
    @Column(name = "Data_ultima_atualizacao")
    @Temporal(TemporalType.DATE)
    private Date dataultimaatualizacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servi\u00e7o")
    private Collection<ServicoOs> servicoOsCollection;

    public Serviço() {
    }

    public Serviço(Integer idServiço) {
        this.idServiço = idServiço;
    }

    public Integer getIdServiço() {
        return idServiço;
    }

    public void setIdServiço(Integer idServiço) {
        this.idServiço = idServiço;
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

    @XmlTransient
    public Collection<ServicoOs> getServicoOsCollection() {
        return servicoOsCollection;
    }

    public void setServicoOsCollection(Collection<ServicoOs> servicoOsCollection) {
        this.servicoOsCollection = servicoOsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServiço != null ? idServiço.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serviço)) {
            return false;
        }
        Serviço other = (Serviço) object;
        if ((this.idServiço == null && other.idServiço != null) || (this.idServiço != null && !this.idServiço.equals(other.idServiço))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Servi\u00e7o[ idServi\u00e7o=" + idServiço + " ]";
    }
    
}

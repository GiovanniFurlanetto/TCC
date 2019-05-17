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
@Table(name = "Ve\u00edculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ve\u00edculo.findAll", query = "SELECT v FROM Ve\u00edculo v"),
    @NamedQuery(name = "Ve\u00edculo.findByIdVe\u00edculo", query = "SELECT v FROM Ve\u00edculo v WHERE v.idVe\u00edculo = :idVe\u00edculo"),
    @NamedQuery(name = "Ve\u00edculo.findByPlaca", query = "SELECT v FROM Ve\u00edculo v WHERE v.placa = :placa"),
    @NamedQuery(name = "Ve\u00edculo.findByModelo", query = "SELECT v FROM Ve\u00edculo v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Ve\u00edculo.findByMarca", query = "SELECT v FROM Ve\u00edculo v WHERE v.marca = :marca"),
    @NamedQuery(name = "Ve\u00edculo.findByAnodefabricacao", query = "SELECT v FROM Ve\u00edculo v WHERE v.anodefabricacao = :anodefabricacao")})
public class Veículo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idVe\u00edculo")
    private Integer idVeículo;
    @Column(name = "Placa")
    private String placa;
    @Column(name = "Modelo")
    private String modelo;
    @Column(name = "Marca")
    private String marca;
    @Column(name = "Ano_de_fabricacao")
    @Temporal(TemporalType.DATE)
    private Date anodefabricacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ve\u00edculo")
    private Collection<Os> osCollection;
    @JoinColumn(name = "Cliente_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente cliente;

    public Veículo() {
    }

    public Veículo(Integer idVeículo) {
        this.idVeículo = idVeículo;
    }

    public Integer getIdVeículo() {
        return idVeículo;
    }

    public void setIdVeículo(Integer idVeículo) {
        this.idVeículo = idVeículo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getAnodefabricacao() {
        return anodefabricacao;
    }

    public void setAnodefabricacao(Date anodefabricacao) {
        this.anodefabricacao = anodefabricacao;
    }

    @XmlTransient
    public Collection<Os> getOsCollection() {
        return osCollection;
    }

    public void setOsCollection(Collection<Os> osCollection) {
        this.osCollection = osCollection;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVeículo != null ? idVeículo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veículo)) {
            return false;
        }
        Veículo other = (Veículo) object;
        if ((this.idVeículo == null && other.idVeículo != null) || (this.idVeículo != null && !this.idVeículo.equals(other.idVeículo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ve\u00edculo[ idVe\u00edculo=" + idVeículo + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author furlanetto
 */
@Entity
@Table(name = "Mec\u00e2nico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mec\u00e2nico.findAll", query = "SELECT m FROM Mec\u00e2nico m"),
    @NamedQuery(name = "Mec\u00e2nico.findByIdMecanico", query = "SELECT m FROM Mec\u00e2nico m WHERE m.idMecanico = :idMecanico"),
    @NamedQuery(name = "Mec\u00e2nico.findByNome", query = "SELECT m FROM Mec\u00e2nico m WHERE m.nome = :nome"),
    @NamedQuery(name = "Mec\u00e2nico.findByCpf", query = "SELECT m FROM Mec\u00e2nico m WHERE m.cpf = :cpf"),
    @NamedQuery(name = "Mec\u00e2nico.findByRg", query = "SELECT m FROM Mec\u00e2nico m WHERE m.rg = :rg"),
    @NamedQuery(name = "Mec\u00e2nico.findByEndereco", query = "SELECT m FROM Mec\u00e2nico m WHERE m.endereco = :endereco"),
    @NamedQuery(name = "Mec\u00e2nico.findByTelefone", query = "SELECT m FROM Mec\u00e2nico m WHERE m.telefone = :telefone"),
    @NamedQuery(name = "Mec\u00e2nico.findByCidade", query = "SELECT m FROM Mec\u00e2nico m WHERE m.cidade = :cidade"),
    @NamedQuery(name = "Mec\u00e2nico.findByBairro", query = "SELECT m FROM Mec\u00e2nico m WHERE m.bairro = :bairro"),
    @NamedQuery(name = "Mec\u00e2nico.findByUf", query = "SELECT m FROM Mec\u00e2nico m WHERE m.uf = :uf"),
    @NamedQuery(name = "Mec\u00e2nico.findByCep", query = "SELECT m FROM Mec\u00e2nico m WHERE m.cep = :cep"),
    @NamedQuery(name = "Mec\u00e2nico.findByEmail", query = "SELECT m FROM Mec\u00e2nico m WHERE m.email = :email")})
public class Mecânico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdMecanico")
    private Integer idMecanico;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "RG")
    private String rg;
    @Column(name = "Endereco")
    private String endereco;
    @Column(name = "Telefone")
    private String telefone;
    @Column(name = "Cidade")
    private String cidade;
    @Column(name = "Bairro")
    private String bairro;
    @Column(name = "UF")
    private String uf;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mec\u00e2nico")
    private Collection<Os> osCollection;

    public Mecânico() {
    }

    public Mecânico(Integer idMecanico) {
        this.idMecanico = idMecanico;
    }

    public Integer getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(Integer idMecanico) {
        this.idMecanico = idMecanico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Os> getOsCollection() {
        return osCollection;
    }

    public void setOsCollection(Collection<Os> osCollection) {
        this.osCollection = osCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMecanico != null ? idMecanico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mecânico)) {
            return false;
        }
        Mecânico other = (Mecânico) object;
        if ((this.idMecanico == null && other.idMecanico != null) || (this.idMecanico != null && !this.idMecanico.equals(other.idMecanico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Mec\u00e2nico[ idMecanico=" + idMecanico + " ]";
    }
    
}

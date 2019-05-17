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
@Table(name = "OS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Os.findAll", query = "SELECT o FROM Os o"),
    @NamedQuery(name = "Os.findByIdOS", query = "SELECT o FROM Os o WHERE o.idOS = :idOS"),
    @NamedQuery(name = "Os.findByDescricaoproblema", query = "SELECT o FROM Os o WHERE o.descricaoproblema = :descricaoproblema"),
    @NamedQuery(name = "Os.findByDataPrevisao", query = "SELECT o FROM Os o WHERE o.dataPrevisao = :dataPrevisao"),
    @NamedQuery(name = "Os.findByValor", query = "SELECT o FROM Os o WHERE o.valor = :valor"),
    @NamedQuery(name = "Os.findByDiagnostico", query = "SELECT o FROM Os o WHERE o.diagnostico = :diagnostico"),
    @NamedQuery(name = "Os.findByDataEntrada", query = "SELECT o FROM Os o WHERE o.dataEntrada = :dataEntrada"),
    @NamedQuery(name = "Os.findByDataOrcamento", query = "SELECT o FROM Os o WHERE o.dataOrcamento = :dataOrcamento"),
    @NamedQuery(name = "Os.findByDataAprovacao", query = "SELECT o FROM Os o WHERE o.dataAprovacao = :dataAprovacao")})
public class Os implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idOS")
    private Integer idOS;
    @Column(name = "Descricao_problema")
    private String descricaoproblema;
    @Column(name = "data_previsao")
    @Temporal(TemporalType.DATE)
    private Date dataPrevisao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Valor")
    private Double valor;
    @Column(name = "diagnostico")
    private String diagnostico;
    @Column(name = "data_entrada")
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @Column(name = "data_orcamento")
    @Temporal(TemporalType.DATE)
    private Date dataOrcamento;
    @Column(name = "data_aprovacao")
    @Temporal(TemporalType.DATE)
    private Date dataAprovacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "os")
    private Collection<PecaUtilizada> pecaUtilizadaCollection;
    @JoinColumn(name = "Mec\u00e2nico_IdMecanico", referencedColumnName = "IdMecanico")
    @ManyToOne(optional = false)
    private Mecânico mecânico;
    @JoinColumn(name = "Ve\u00edculo_idVe\u00edculo", referencedColumnName = "idVe\u00edculo")
    @ManyToOne(optional = false)
    private Veículo veículo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "os")
    private Collection<Recebimento> recebimentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "os")
    private Collection<ServicoOs> servicoOsCollection;

    public Os() {
    }

    public Os(Integer idOS) {
        this.idOS = idOS;
    }

    public Integer getIdOS() {
        return idOS;
    }

    public void setIdOS(Integer idOS) {
        this.idOS = idOS;
    }

    public String getDescricaoproblema() {
        return descricaoproblema;
    }

    public void setDescricaoproblema(String descricaoproblema) {
        this.descricaoproblema = descricaoproblema;
    }

    public Date getDataPrevisao() {
        return dataPrevisao;
    }

    public void setDataPrevisao(Date dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataOrcamento() {
        return dataOrcamento;
    }

    public void setDataOrcamento(Date dataOrcamento) {
        this.dataOrcamento = dataOrcamento;
    }

    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    @XmlTransient
    public Collection<PecaUtilizada> getPecaUtilizadaCollection() {
        return pecaUtilizadaCollection;
    }

    public void setPecaUtilizadaCollection(Collection<PecaUtilizada> pecaUtilizadaCollection) {
        this.pecaUtilizadaCollection = pecaUtilizadaCollection;
    }

    public Mecânico getMecânico() {
        return mecânico;
    }

    public void setMecânico(Mecânico mecânico) {
        this.mecânico = mecânico;
    }

    public Veículo getVeículo() {
        return veículo;
    }

    public void setVeículo(Veículo veículo) {
        this.veículo = veículo;
    }

    @XmlTransient
    public Collection<Recebimento> getRecebimentoCollection() {
        return recebimentoCollection;
    }

    public void setRecebimentoCollection(Collection<Recebimento> recebimentoCollection) {
        this.recebimentoCollection = recebimentoCollection;
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
        hash += (idOS != null ? idOS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Os)) {
            return false;
        }
        Os other = (Os) object;
        if ((this.idOS == null && other.idOS != null) || (this.idOS != null && !this.idOS.equals(other.idOS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Os[ idOS=" + idOS + " ]";
    }
    
}

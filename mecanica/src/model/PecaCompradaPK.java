/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author furlanetto
 */
@Embeddable
public class PecaCompradaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "compra_numero_nf")
    private int compraNumeroNf;
    @Basic(optional = false)
    @Column(name = "compra_Fornecedor_idFornecedor")
    private int compraFornecedoridFornecedor;
    @Basic(optional = false)
    @Column(name = "Pe\u00e7a_idPe\u00e7a")
    private int peçaidPeça;

    public PecaCompradaPK() {
    }

    public PecaCompradaPK(int compraNumeroNf, int compraFornecedoridFornecedor, int peçaidPeça) {
        this.compraNumeroNf = compraNumeroNf;
        this.compraFornecedoridFornecedor = compraFornecedoridFornecedor;
        this.peçaidPeça = peçaidPeça;
    }

    public int getCompraNumeroNf() {
        return compraNumeroNf;
    }

    public void setCompraNumeroNf(int compraNumeroNf) {
        this.compraNumeroNf = compraNumeroNf;
    }

    public int getCompraFornecedoridFornecedor() {
        return compraFornecedoridFornecedor;
    }

    public void setCompraFornecedoridFornecedor(int compraFornecedoridFornecedor) {
        this.compraFornecedoridFornecedor = compraFornecedoridFornecedor;
    }

    public int getPeçaidPeça() {
        return peçaidPeça;
    }

    public void setPeçaidPeça(int peçaidPeça) {
        this.peçaidPeça = peçaidPeça;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) compraNumeroNf;
        hash += (int) compraFornecedoridFornecedor;
        hash += (int) peçaidPeça;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PecaCompradaPK)) {
            return false;
        }
        PecaCompradaPK other = (PecaCompradaPK) object;
        if (this.compraNumeroNf != other.compraNumeroNf) {
            return false;
        }
        if (this.compraFornecedoridFornecedor != other.compraFornecedoridFornecedor) {
            return false;
        }
        if (this.peçaidPeça != other.peçaidPeça) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PecaCompradaPK[ compraNumeroNf=" + compraNumeroNf + ", compraFornecedoridFornecedor=" + compraFornecedoridFornecedor + ", pe\u00e7aidPe\u00e7a=" + peçaidPeça + " ]";
    }
    
}

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
public class CompraPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "numero_nf")
    private int numeroNf;
    @Basic(optional = false)
    @Column(name = "Fornecedor_idFornecedor")
    private int fornecedoridFornecedor;

    public CompraPK() {
    }

    public CompraPK(int numeroNf, int fornecedoridFornecedor) {
        this.numeroNf = numeroNf;
        this.fornecedoridFornecedor = fornecedoridFornecedor;
    }

    public int getNumeroNf() {
        return numeroNf;
    }

    public void setNumeroNf(int numeroNf) {
        this.numeroNf = numeroNf;
    }

    public int getFornecedoridFornecedor() {
        return fornecedoridFornecedor;
    }

    public void setFornecedoridFornecedor(int fornecedoridFornecedor) {
        this.fornecedoridFornecedor = fornecedoridFornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numeroNf;
        hash += (int) fornecedoridFornecedor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraPK)) {
            return false;
        }
        CompraPK other = (CompraPK) object;
        if (this.numeroNf != other.numeroNf) {
            return false;
        }
        if (this.fornecedoridFornecedor != other.fornecedoridFornecedor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CompraPK[ numeroNf=" + numeroNf + ", fornecedoridFornecedor=" + fornecedoridFornecedor + " ]";
    }
    
}

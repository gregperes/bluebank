/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluebankConexao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author davi_
 */
@Entity
@Table(name = "extrato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Extrato.findAll", query = "SELECT e FROM Extrato e")
    , @NamedQuery(name = "Extrato.findByIdextrato", query = "SELECT e FROM Extrato e WHERE e.idextrato = :idextrato")
    , @NamedQuery(name = "Extrato.findByData", query = "SELECT e FROM Extrato e WHERE e.data = :data")
    , @NamedQuery(name = "Extrato.findBySaldo", query = "SELECT e FROM Extrato e WHERE e.saldo = :saldo")})
public class Extrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDEXTRATO")
    private Integer idextrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALDO")
    private BigDecimal saldo;
    @JoinColumn(name = "IDCONTA", referencedColumnName = "IDCONTA")
    @ManyToOne(optional = false)
    private Conta idconta;
    @JoinColumn(name = "IDPROCEDIMENTO", referencedColumnName = "IDPROCEDIMENTO")
    @ManyToOne(optional = false)
    private Procedimento idprocedimento;

    public Extrato() {
    }

    public Extrato(Integer idextrato) {
        this.idextrato = idextrato;
    }

    public Extrato(Integer idextrato, Date data, BigDecimal saldo) {
        this.idextrato = idextrato;
        this.data = data;
        this.saldo = saldo;
    }

    public Integer getIdextrato() {
        return idextrato;
    }

    public void setIdextrato(Integer idextrato) {
        this.idextrato = idextrato;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Conta getIdconta() {
        return idconta;
    }

    public void setIdconta(Conta idconta) {
        this.idconta = idconta;
    }

    public Procedimento getIdprocedimento() {
        return idprocedimento;
    }

    public void setIdprocedimento(Procedimento idprocedimento) {
        this.idprocedimento = idprocedimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idextrato != null ? idextrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Extrato)) {
            return false;
        }
        Extrato other = (Extrato) object;
        if ((this.idextrato == null && other.idextrato != null) || (this.idextrato != null && !this.idextrato.equals(other.idextrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bluebankConexao.Extrato[ idextrato=" + idextrato + " ]";
    }
    
}

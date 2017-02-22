/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluebankConexao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author davi_
 */
@Entity
@Table(name = "conta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conta.findAll", query = "SELECT c FROM Conta c")
    , @NamedQuery(name = "Conta.findByIdconta", query = "SELECT c FROM Conta c WHERE c.idconta = :idconta")
    , @NamedQuery(name = "Conta.findByConta", query = "SELECT c FROM Conta c WHERE c.conta = :conta")
    , @NamedQuery(name = "Conta.findBySenha", query = "SELECT c FROM Conta c WHERE c.senha = :senha")})
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCONTA")
    private Integer idconta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CONTA")
    private String conta;
    @Size(max = 45)
    @Column(name = "SENHA")
    private String senha;
    @JoinColumn(name = "IDAGENCIA", referencedColumnName = "IDAGENCIA")
    @ManyToOne(optional = false)
    private Agencia idagencia;
    @JoinColumn(name = "IDCORRENTISTA", referencedColumnName = "IDCORRENTISTA")
    @ManyToOne(optional = false)
    private Correntista idcorrentista;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idconta")
    private List<Extrato> extratoList;

    public Conta() {
    }

    public Conta(Integer idconta) {
        this.idconta = idconta;
    }

    public Conta(Integer idconta, String conta) {
        this.idconta = idconta;
        this.conta = conta;
    }

    public Integer getIdconta() {
        return idconta;
    }

    public void setIdconta(Integer idconta) {
        this.idconta = idconta;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Agencia getIdagencia() {
        return idagencia;
    }

    public void setIdagencia(Agencia idagencia) {
        this.idagencia = idagencia;
    }

    public Correntista getIdcorrentista() {
        return idcorrentista;
    }

    public void setIdcorrentista(Correntista idcorrentista) {
        this.idcorrentista = idcorrentista;
    }

    @XmlTransient
    public List<Extrato> getExtratoList() {
        return extratoList;
    }

    public void setExtratoList(List<Extrato> extratoList) {
        this.extratoList = extratoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconta != null ? idconta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conta)) {
            return false;
        }
        Conta other = (Conta) object;
        if ((this.idconta == null && other.idconta != null) || (this.idconta != null && !this.idconta.equals(other.idconta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bluebankConexao.Conta[ idconta=" + idconta + " ]";
    }
    
}

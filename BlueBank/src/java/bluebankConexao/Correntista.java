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
@Table(name = "correntista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Correntista.findAll", query = "SELECT c FROM Correntista c")
    , @NamedQuery(name = "Correntista.findByIdcorrentista", query = "SELECT c FROM Correntista c WHERE c.idcorrentista = :idcorrentista")
    , @NamedQuery(name = "Correntista.findByNomeCorrentista", query = "SELECT c FROM Correntista c WHERE c.nomeCorrentista = :nomeCorrentista")
    , @NamedQuery(name = "Correntista.findByCpf", query = "SELECT c FROM Correntista c WHERE c.cpf = :cpf")})
public class Correntista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCORRENTISTA")
    private Integer idcorrentista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOME_CORRENTISTA")
    private String nomeCorrentista;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CPF")
    private int cpf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcorrentista")
    private List<Conta> contaList;

    public Correntista() {
    }

    public Correntista(Integer idcorrentista) {
        this.idcorrentista = idcorrentista;
    }

    public Correntista(Integer idcorrentista, String nomeCorrentista, int cpf) {
        this.idcorrentista = idcorrentista;
        this.nomeCorrentista = nomeCorrentista;
        this.cpf = cpf;
    }

    public Integer getIdcorrentista() {
        return idcorrentista;
    }

    public void setIdcorrentista(Integer idcorrentista) {
        this.idcorrentista = idcorrentista;
    }

    public String getNomeCorrentista() {
        return nomeCorrentista;
    }

    public void setNomeCorrentista(String nomeCorrentista) {
        this.nomeCorrentista = nomeCorrentista;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    @XmlTransient
    public List<Conta> getContaList() {
        return contaList;
    }

    public void setContaList(List<Conta> contaList) {
        this.contaList = contaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcorrentista != null ? idcorrentista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Correntista)) {
            return false;
        }
        Correntista other = (Correntista) object;
        if ((this.idcorrentista == null && other.idcorrentista != null) || (this.idcorrentista != null && !this.idcorrentista.equals(other.idcorrentista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bluebankConexao.Correntista[ idcorrentista=" + idcorrentista + " ]";
    }
    
}

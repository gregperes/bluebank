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
@Table(name = "agencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agencia.findAll", query = "SELECT a FROM Agencia a")
    , @NamedQuery(name = "Agencia.findByIdagencia", query = "SELECT a FROM Agencia a WHERE a.idagencia = :idagencia")
    , @NamedQuery(name = "Agencia.findByAgencia", query = "SELECT a FROM Agencia a WHERE a.agencia = :agencia")
    , @NamedQuery(name = "Agencia.findByLocal", query = "SELECT a FROM Agencia a WHERE a.local = :local")})
public class Agencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDAGENCIA")
    private Integer idagencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "AGENCIA")
    private String agencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "LOCAL")
    private String local;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idagencia")
    private List<Conta> contaList;
    @JoinColumn(name = "IDBANCO", referencedColumnName = "IDBANCO")
    @ManyToOne(optional = false)
    private Banco idbanco;

    public Agencia() {
    }

    public Agencia(Integer idagencia) {
        this.idagencia = idagencia;
    }

    public Agencia(Integer idagencia, String agencia, String local) {
        this.idagencia = idagencia;
        this.agencia = agencia;
        this.local = local;
    }

    public Integer getIdagencia() {
        return idagencia;
    }

    public void setIdagencia(Integer idagencia) {
        this.idagencia = idagencia;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @XmlTransient
    public List<Conta> getContaList() {
        return contaList;
    }

    public void setContaList(List<Conta> contaList) {
        this.contaList = contaList;
    }

    public Banco getIdbanco() {
        return idbanco;
    }

    public void setIdbanco(Banco idbanco) {
        this.idbanco = idbanco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idagencia != null ? idagencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agencia)) {
            return false;
        }
        Agencia other = (Agencia) object;
        if ((this.idagencia == null && other.idagencia != null) || (this.idagencia != null && !this.idagencia.equals(other.idagencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bluebankConexao.Agencia[ idagencia=" + idagencia + " ]";
    }
    
}

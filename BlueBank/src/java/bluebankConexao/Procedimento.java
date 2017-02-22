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
@Table(name = "procedimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procedimento.findAll", query = "SELECT p FROM Procedimento p")
    , @NamedQuery(name = "Procedimento.findByIdprocedimento", query = "SELECT p FROM Procedimento p WHERE p.idprocedimento = :idprocedimento")
    , @NamedQuery(name = "Procedimento.findByProcedimento", query = "SELECT p FROM Procedimento p WHERE p.procedimento = :procedimento")})
public class Procedimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPROCEDIMENTO")
    private Integer idprocedimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PROCEDIMENTO")
    private String procedimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprocedimento")
    private List<Extrato> extratoList;

    public Procedimento() {
    }

    public Procedimento(Integer idprocedimento) {
        this.idprocedimento = idprocedimento;
    }

    public Procedimento(Integer idprocedimento, String procedimento) {
        this.idprocedimento = idprocedimento;
        this.procedimento = procedimento;
    }

    public Integer getIdprocedimento() {
        return idprocedimento;
    }

    public void setIdprocedimento(Integer idprocedimento) {
        this.idprocedimento = idprocedimento;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
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
        hash += (idprocedimento != null ? idprocedimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procedimento)) {
            return false;
        }
        Procedimento other = (Procedimento) object;
        if ((this.idprocedimento == null && other.idprocedimento != null) || (this.idprocedimento != null && !this.idprocedimento.equals(other.idprocedimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bluebankConexao.Procedimento[ idprocedimento=" + idprocedimento + " ]";
    }
    
}

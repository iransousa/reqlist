/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author iran.freitas
 */
@Entity
@Table(name = "requisito", catalog = "reqlist", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisito.findAll", query = "SELECT r FROM Requisito r"),
    @NamedQuery(name = "Requisito.findById", query = "SELECT r FROM Requisito r WHERE r.id = :id"),
    @NamedQuery(name = "Requisito.findByTitulo", query = "SELECT r FROM Requisito r WHERE r.titulo = :titulo"),
    @NamedQuery(name = "Requisito.findByData", query = "SELECT r FROM Requisito r WHERE r.data = :data"),
    @NamedQuery(name = "Requisito.findByTipo", query = "SELECT r FROM Requisito r WHERE r.tipo = :tipo"),
    @NamedQuery(name = "Requisito.findByStatus", query = "SELECT r FROM Requisito r WHERE r.status = :status")})
public class Requisito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "titulo")
    private String titulo;
    @Lob
    @Size(max = 65535)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private int tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @ManyToMany(mappedBy = "requisitoList")
    private List<Objetivo> objetivoList;
    @ManyToMany(mappedBy = "requisitoList")
    private List<Escopo> escopoList;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;
    @JoinColumn(name = "projeto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Projeto projetoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitoId")
    private List<Tarefa> tarefaList;

    public Requisito() {
    }

    public Requisito(Integer id) {
        this.id = id;
    }

    public Requisito(Integer id, String titulo, Date data, int tipo, int status) {
        this.id = id;
        this.titulo = titulo;
        this.data = data;
        this.tipo = tipo;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public List<Objetivo> getObjetivoList() {
        return objetivoList;
    }

    public void setObjetivoList(List<Objetivo> objetivoList) {
        this.objetivoList = objetivoList;
    }

    @XmlTransient
    public List<Escopo> getEscopoList() {
        return escopoList;
    }

    public void setEscopoList(List<Escopo> escopoList) {
        this.escopoList = escopoList;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Projeto getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(Projeto projetoId) {
        this.projetoId = projetoId;
    }

    @XmlTransient
    public List<Tarefa> getTarefaList() {
        return tarefaList;
    }

    public void setTarefaList(List<Tarefa> tarefaList) {
        this.tarefaList = tarefaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisito)) {
            return false;
        }
        Requisito other = (Requisito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "reqlist.entity.Requisito[ id=" + id + " ]";
    }
    
}

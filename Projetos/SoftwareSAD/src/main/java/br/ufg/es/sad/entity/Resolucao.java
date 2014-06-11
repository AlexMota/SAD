package br.ufg.es.sad.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "resolucao")
public class Resolucao implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "nome", length = 45)
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(name = "ano", length = 0)
    private Date ano;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "grupo_resolucao", catalog = "resolucao", joinColumns = {
        @JoinColumn(name = "resolucao_id", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "grupo_id", nullable = false, updatable = false)})
    private Set<Grupo> grupos = new HashSet<Grupo>(0);

    public Resolucao() {
    }
    
    public Resolucao(String nome, Date ano) {
        this.nome = nome;
        this.ano = ano;
    }

    public Resolucao(String nome, Date ano, Set grupos) {
        this.nome = nome;
        this.ano = ano;
        this.grupos = grupos;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getAno() {
        return this.ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public Set<Grupo> getGrupos() {
        return this.grupos;
    }

    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }

    @Override
    public String toString() {
        return "Id: " + id + " Nome:  " + nome + " Ano: " + ano;
    }
    
    

}

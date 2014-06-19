package br.ufg.es.sad.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grupo")
public class Grupo implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "grupo_resolucao", joinColumns = {
        @JoinColumn(name = "grupo_id", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "resolucao_id", nullable = false, updatable = false)})
    private Set<Resolucao> resolucaos = new HashSet<Resolucao>(0);

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "atividade_grupo", joinColumns = {
        @JoinColumn(name = "grupo_id", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "atividade_id", nullable = false, updatable = false)})
    private Set<Atividade> atividades = new HashSet<Atividade>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo")
    private Set<Grupo> grupos = new HashSet<Grupo>(0);

    public Grupo() {
    }

    public Grupo(String nome) {
        this.nome = nome;
    }

    public Grupo(Grupo grupo, String nome, Set<Resolucao> resolucaos, Set<Atividade> atividades, Set<Grupo> grupos) {
        this.grupo = grupo;
        this.nome = nome;
        this.resolucaos = resolucaos;
        this.atividades = atividades;
        this.grupos = grupos;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Grupo getGrupo() {
        return this.grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Resolucao> getResolucaos() {
        return this.resolucaos;
    }

    public void setResolucaos(Set<Resolucao> resolucaos) {
        this.resolucaos = resolucaos;
    }

    public Set<Atividade> getAtividades() {
        return this.atividades;
    }

    public void setAtividades(Set<Atividade> atividades) {
        this.atividades = atividades;
    }

    public Set<Grupo> getGrupos() {
        return this.grupos;
    }

    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }

    @Override
    public String toString() {
        return "ID: " + id + " NOME: " + nome;
    }

}

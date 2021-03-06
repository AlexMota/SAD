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

/**
 * Entidade que define o grupo de uma determinada atividade.<br>
 * Esse grupo deve pertencer a uma ou mais <code>Resolucao</code>.<br>
 * Esse grupo pode pertencer a outro(s) <code>Grupo</code>(s).<br>
 * Esse grupo pode conter varias <code>Grupo</code>(s).<br>
 * Esse grupo pode conter varias <code>Atividade</code>(s).<br>
 *
 * @author Phelipe Alves de Souza
 * @since 02/07/2014
 * @version 0.1
 */
@Entity
@Table(name = Grupo.NAME)
public class Grupo implements java.io.Serializable {

    public static final String NAME = "grupo";

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @Column(name = "nome", nullable = false)
    private String nome;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "grupo_resolucao", joinColumns = {
        @JoinColumn(name = "grupo_id", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "resolucao_id", nullable = false, updatable = false)})
    private Set<Resolucao> resolucoes = new HashSet<Resolucao>(0);

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "atividade_grupo", joinColumns = {
        @JoinColumn(name = "grupo_id", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "atividade_id", nullable = false, updatable = false)})
    private Set<Atividade> atividades = new HashSet<Atividade>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo", cascade = CascadeType.ALL)
    private Set<Grupo> grupos = new HashSet<Grupo>(0);

    public Grupo() {
    }

    /**
     *
     * @param resolucao
     * @param nome
     */
    public Grupo(Resolucao resolucao, String nome) {
        this.resolucoes.add(resolucao);
        this.nome = nome;
    }

    /**
     *
     * @param resolucao
     * @param grupo
     * @param nome
     */
    public Grupo(Resolucao resolucao, Grupo grupo, String nome) {
        this.resolucoes.add(resolucao);
        this.grupo = grupo;
        this.nome = nome;
    }

    /**
     *
     * @param resolucao
     * @param grupo
     * @param grupos
     * @param nome
     */
    public Grupo(Resolucao resolucao, Grupo grupo, Set<Grupo> grupos, String nome) {
        this.resolucoes.add(resolucao);
        this.grupo = grupo;
        this.grupos = grupos;
        this.nome = nome;
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

    public Set<Resolucao> getResolucoes() {
        return this.resolucoes;
    }

    public void setResolucoes(Set<Resolucao> resolucoes) {
        this.resolucoes = resolucoes;
    }

    public void addResolucao(Resolucao resolucao) {
        if (resolucao != null) {
            this.resolucoes.add(resolucao);
        }
    }

    public Set<Atividade> getAtividades() {
        return this.atividades;
    }

    public void addAtividade(Atividade atividade) {
        this.atividades.add(atividade);
    }

    public Set<Grupo> getGrupos() {
        return this.grupos;
    }

    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }

    public void addGrupo(Grupo grupo) {
        this.grupos.add(grupo);
    }

    @Override
    public String toString() {
        return "ID: " + id + " NOME: " + nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 47 * hash + (this.grupo != null ? this.grupo.hashCode() : 0);
        hash = 47 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grupo other = (Grupo) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.grupo != other.grupo && (this.grupo == null || !this.grupo.equals(other.grupo))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if (this.resolucoes != other.resolucoes && (this.resolucoes == null || !this.resolucoes.equals(other.resolucoes))) {
            return false;
        }
        if (this.atividades != other.atividades && (this.atividades == null || !this.atividades.equals(other.atividades))) {
            return false;
        }
        if (this.grupos != other.grupos && (this.grupos == null || !this.grupos.equals(other.grupos))) {
            return false;
        }
        return true;
    }

}

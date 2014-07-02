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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = Atividade.NAME)
public class Atividade implements java.io.Serializable {

    public static final String NAME = "atividade";

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "atividade_grupo", joinColumns = {
        @JoinColumn(name = "atividade_id", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "grupo_id", nullable = false, updatable = false)})
    private Set<Grupo> grupos = new HashSet<Grupo>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = AtividadeResolucao.ATIVIDADE, cascade = CascadeType.ALL)
    private Set<AtividadeResolucao> atividadeResolucaos = new HashSet<AtividadeResolucao>(0);

    public Atividade() {
    }

    public Atividade(String nome, Resolucao resolucao, double valor) {
        this.nome = nome;
        this.addResolucao(resolucao, valor);
    }

    public Atividade(String nome, Resolucao resolucao, Grupo grupo, double valor) {
        this.nome = nome;
        this.grupos.add(grupo);
        this.addResolucao(resolucao, valor);
    }

    public Atividade(String nome, Set<Grupo> grupos, Set<AtividadeResolucao> atividadeResolucaos) {
        this.nome = nome;
        this.grupos = grupos;
        this.atividadeResolucaos = atividadeResolucaos;
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

    public Set<Grupo> getGrupos() {
        return this.grupos;
    }

    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }

    public void addGrupo(Grupo grupo) {
        this.grupos.add(grupo);
    }

    public Set<AtividadeResolucao> getAtividadeResolucaos() {
        return this.atividadeResolucaos;
    }

    public void setAtividadeResolucaos(Set<AtividadeResolucao> atividadeResolucaos) {
        this.atividadeResolucaos = atividadeResolucaos;
    }

    public void addAtividadeResolucao(AtividadeResolucao atividadeResolucao) {
        this.atividadeResolucaos.add(atividadeResolucao);
    }

    /**
     * Adicionar a atividade atual na resoluçao x com tendo como valor y
     *
     * @param resolucao resolução que atividade vai pertencer
     * @param valor valor da atividade na resoluçao
     */
    public void addResolucao(Resolucao resolucao, double valor) {
        this.atividadeResolucaos.add(new AtividadeResolucao(this, resolucao, valor));
    }

    @Override
    public String toString() {
        return "ID: " + id + " NOME: " + nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Atividade other = (Atividade) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if (this.grupos != other.grupos && (this.grupos == null || !this.grupos.equals(other.grupos))) {
            return false;
        }
        if (this.atividadeResolucaos != other.atividadeResolucaos && (this.atividadeResolucaos == null || !this.atividadeResolucaos.equals(other.atividadeResolucaos))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 41 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        return hash;
    }

}

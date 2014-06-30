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
@Table(name = Resolucao.NAME)
public class Resolucao implements java.io.Serializable {

    public static final String NAME = "resolucao";

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resolucao", cascade = CascadeType.ALL)
    private Set<AtividadeResolucao> atividadesResolucao = new HashSet<AtividadeResolucao>(0);

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "grupo_resolucao", joinColumns = {
        @JoinColumn(name = "resolucao_id", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "grupo_id", nullable = false, updatable = false)})
    private Set<Grupo> grupos = new HashSet<Grupo>(0);

    public Resolucao() {
    }

    public Resolucao(String nome) {
        this.nome = nome;
    }

    public Resolucao(String nome, Set<AtividadeResolucao> atividadeResolucaos, Set<Grupo> grupos) {
        this.nome = nome;
        this.atividadesResolucao = atividadeResolucaos;
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

    public Set<AtividadeResolucao> getAtividadeResolucaos() {
        return this.atividadesResolucao;
    }

    public void setAtividadeResolucaos(Set<AtividadeResolucao> atividadeResolucaos) {
        this.atividadesResolucao = atividadeResolucaos;
    }

    public void addAtividadeResolucao(AtividadeResolucao atividadeResolucao) {
        if (atividadeResolucao != null) {
            this.atividadesResolucao.add(atividadeResolucao);
        }
    }

    /**
     *
     * Adicionar atividade na resolução
     *
     * @param atividade
     * @param valor
     */
    public void addAtividade(Atividade atividade, double valor) {
        this.atividadesResolucao.add(new AtividadeResolucao(this, atividade, valor));
    }

    public Set<Grupo> getGrupos() {
        return this.grupos;
    }

    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }

    public void addGrupo(Grupo grupo) {
        if (grupo != null) {
            this.grupos.add(grupo);
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + " NOME: " + nome;
    }
}

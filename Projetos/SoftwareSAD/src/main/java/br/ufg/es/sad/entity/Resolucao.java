package br.ufg.es.sad.entity;

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

@Entity
@Table(name = "resolucao")
public class Resolucao implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "nome", length = 45)
    private String nome;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "atividade_resolucao", catalog = "phelipea_sad", joinColumns = {
        @JoinColumn(name = "resolucao_id", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "atividade_id", nullable = false, updatable = false)})
    private Set<Atividade> atividades = new HashSet<Atividade>(0);

    public Resolucao() {
    }

    public Resolucao(String nome) {
        this.nome = nome;
    }

    public Resolucao(String nome, Set atividades) {
        this.nome = nome;
        this.atividades = atividades;
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

    public Set<Atividade> getAtividades() {
        return this.atividades;
    }

    public void setAtividades(Set<Atividade> atividades) {
        this.atividades = atividades;
    }

    @Override
    public String toString() {
        return "Resolução -> "+ "Id: " + id + " Nome: " + nome;
    }
    
    

}

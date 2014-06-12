package br.ufg.es.sad.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "valor")
public class Valor implements java.io.Serializable {

    public static final int PADRAO = 1;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "peso", nullable = false)
    private int peso;

    @Column(name = "pontuacao", nullable = false)
    private int pontuacao;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "valor")
    private Set<Atividade> atividades = new HashSet<Atividade>(0);

    public Valor() {
    }

    public Valor(int peso, int pontuacao) {
        this.peso = peso;
        this.pontuacao = pontuacao;
    }

    public Valor(int peso, int pontuacao, Atividade atividade) {
        this.peso = peso;
        this.pontuacao = pontuacao;
        this.atividades.add(atividade);
    }

    public Valor(int peso, int pontuacao, Set<Atividade> atividades) {
        this.peso = peso;
        this.pontuacao = pontuacao;
        this.atividades = atividades;
    }

    public boolean addAtividade(Atividade atividade) {
        return this.atividades.add(atividade);
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPeso() {
        return this.peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getPontuacao() {
        return this.pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Set<Atividade> getAtividades() {
        return this.atividades;
    }

    public void setAtividades(Set<Atividade> atividades) {
        this.atividades = atividades;
    }

}

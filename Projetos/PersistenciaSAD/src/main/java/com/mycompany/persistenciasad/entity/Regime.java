package com.mycompany.persistenciasad.entity;

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
@Table(name = "regime")
public class Regime implements java.io.Serializable {

    private Integer id;
    private String nome;
    private int horas;
    private Set evaluations = new HashSet(0);

    public Regime() {
    }

    public Regime(String nome, int horas) {
        this.nome = nome;
        this.horas = horas;
    }

    public Regime(String nome, int horas, Set evaluations) {
        this.nome = nome;
        this.horas = horas;
        this.evaluations = evaluations;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "nome", nullable = false, length = 45)
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "horas", nullable = false)
    public int getHoras() {
        return this.horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "regime")
    public Set getEvaluations() {
        return this.evaluations;
    }

    public void setEvaluations(Set evaluations) {
        this.evaluations = evaluations;
    }

}

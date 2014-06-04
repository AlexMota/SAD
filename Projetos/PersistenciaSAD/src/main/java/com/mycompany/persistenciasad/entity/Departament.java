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
@Table(name = "departament")
public class Departament implements java.io.Serializable {

    private Integer id;
    private String name;
    private Set evaluations = new HashSet(0);

    public Departament() {
    }

    public Departament(String name) {
        this.name = name;
    }

    public Departament(String name, Set evaluations) {
        this.name = name;
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

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "departament")
    public Set getEvaluations() {
        return this.evaluations;
    }

    public void setEvaluations(Set evaluations) {
        this.evaluations = evaluations;
    }

}

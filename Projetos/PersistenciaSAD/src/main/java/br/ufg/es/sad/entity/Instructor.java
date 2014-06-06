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
@Table(name = "instructor")
public class Instructor implements java.io.Serializable {

    private Integer id;
    private String name;
    private int registration;
    private Set<Evaluation> evaluations = new HashSet<Evaluation>(0);

    public Instructor() {
    }

    public Instructor(String name, int registration) {
        this.name = name;
        this.registration = registration;
    }

    public Instructor(String name, int registration, Set evaluations) {
        this.name = name;
        this.registration = registration;
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

    @Column(name = "registration", nullable = false)
    public int getRegistration() {
        return this.registration;
    }

    public void setRegistration(int registration) {
        this.registration = registration;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instructor")
    public Set<Evaluation> getEvaluations() {
        return this.evaluations;
    }

    public void setEvaluations(Set<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

}

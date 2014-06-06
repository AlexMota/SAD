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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "evaluation")
public class Evaluation implements java.io.Serializable {

    private Integer id;
    private Departament departament;
    private Regime regime;
    private Instructor instructor;
    private int process;
    private int period;
    private Set<Radoc> radocs = new HashSet<Radoc>(0);

    public Evaluation() {
    }

    public Evaluation(Departament departament, Regime regime, Instructor instructor, int process, int period) {
        this.departament = departament;
        this.regime = regime;
        this.instructor = instructor;
        this.process = process;
        this.period = period;
    }

    public Evaluation(Departament departament, Regime regime, Instructor instructor, int process, int period, Set radocs) {
        this.departament = departament;
        this.regime = regime;
        this.instructor = instructor;
        this.process = process;
        this.period = period;
        this.radocs = radocs;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departament_id", nullable = false)
    public Departament getDepartament() {
        return this.departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regime_id", nullable = false)
    public Regime getRegime() {
        return this.regime;
    }

    public void setRegime(Regime regime) {
        this.regime = regime;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id", nullable = false)
    public Instructor getInstructor() {
        return this.instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Column(name = "process", nullable = false)
    public int getProcess() {
        return this.process;
    }

    public void setProcess(int process) {
        this.process = process;
    }

    @Column(name = "period", nullable = false)
    public int getPeriod() {
        return this.period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "evaluation")
    public Set<Radoc> getRadocs() {
        return this.radocs;
    }

    public void setRadocs(Set<Radoc> radocs) {
        this.radocs = radocs;
    }

}

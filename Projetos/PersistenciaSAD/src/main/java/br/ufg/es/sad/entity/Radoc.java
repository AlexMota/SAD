package br.ufg.es.sad.entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "radoc")
public class Radoc implements java.io.Serializable {

    private Integer id;
    private Evaluation evaluation;
    private Date year;
    private int months;
    private Set<PartialResult> partialResults = new HashSet<PartialResult>(0);

    public Radoc() {
    }

    public Radoc(Evaluation evaluation, Date year, int months) {
        this.evaluation = evaluation;
        this.year = year;
        this.months = months;
    }

    public Radoc(Evaluation evaluation, Date year, int months, Set partialResults) {
        this.evaluation = evaluation;
        this.year = year;
        this.months = months;
        this.partialResults = partialResults;
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
    @JoinColumn(name = "evaluation_id", nullable = false)
    public Evaluation getEvaluation() {
        return this.evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "year", nullable = false, length = 0)
    public Date getYear() {
        return this.year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    @Column(name = "months", nullable = false)
    public int getMonths() {
        return this.months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "radoc")
    public Set<PartialResult> getPartialResults() {
        return this.partialResults;
    }

    public void setPartialResults(Set<PartialResult> partialResults) {
        this.partialResults = partialResults;
    }

}

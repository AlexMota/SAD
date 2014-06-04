package com.mycompany.persistenciasad.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "values")
public class Values implements java.io.Serializable {

    private Integer id;
    private Activity activity;
    private int weight;
    private int punctuation;

    public Values() {
    }

    public Values(Activity activity, int weight, int punctuation) {
        this.activity = activity;
        this.weight = weight;
        this.punctuation = punctuation;
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
    @JoinColumn(name = "activity_id", nullable = false)
    public Activity getActivity() {
        return this.activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Column(name = "weight", nullable = false)
    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Column(name = "punctuation", nullable = false)
    public int getPunctuation() {
        return this.punctuation;
    }

    public void setPunctuation(int punctuation) {
        this.punctuation = punctuation;
    }

}

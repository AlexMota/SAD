package br.ufg.es.sad.entity;

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
@Table(name = "partial_result")
public class PartialResult implements java.io.Serializable {

    private Integer id;
    private Group group;
    private Radoc radoc;
    private float value;

    public PartialResult() {
    }

    public PartialResult(Group group, Radoc radoc, float value) {
        this.group = group;
        this.radoc = radoc;
        this.value = value;
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
    @JoinColumn(name = "group_id", nullable = false)
    public Group getGroup() {
        return this.group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "radoc_id", nullable = false)
    public Radoc getRadoc() {
        return this.radoc;
    }

    public void setRadoc(Radoc radoc) {
        this.radoc = radoc;
    }

    @Column(name = "value", nullable = false, precision = 12, scale = 0)
    public float getValue() {
        return this.value;
    }

    public void setValue(float value) {
        this.value = value;
    }

}

package com.mycompany.persistenciasad.entity;

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
@Table(name = "activity")
public class Activity implements java.io.Serializable {

    private Integer id;
    private Group group;
    private String name;
    private Set valueses = new HashSet(0);

    public Activity() {
    }

    public Activity(Group group, String name) {
        this.group = group;
        this.name = name;
    }

    public Activity(Group group, String name, Set valueses) {
        this.group = group;
        this.name = name;
        this.valueses = valueses;
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

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "activity")
    public Set getValueses() {
        return this.valueses;
    }

    public void setValueses(Set valueses) {
        this.valueses = valueses;
    }

}

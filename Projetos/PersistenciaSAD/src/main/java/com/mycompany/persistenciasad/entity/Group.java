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
@Table(name = "group")
public class Group implements java.io.Serializable {

    private Integer id;
    private Area area;
    private String name;
    private Set activities = new HashSet(0);
    private Set partialResults = new HashSet(0);

    public Group() {
    }

    public Group(Area area, String name) {
        this.area = area;
        this.name = name;
    }

    public Group(Area area, String name, Set activities, Set partialResults) {
        this.area = area;
        this.name = name;
        this.activities = activities;
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
    @JoinColumn(name = "area_id", nullable = false)
    public Area getArea() {
        return this.area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    public Set getActivities() {
        return this.activities;
    }

    public void setActivities(Set activities) {
        this.activities = activities;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    public Set getPartialResults() {
        return this.partialResults;
    }

    public void setPartialResults(Set partialResults) {
        this.partialResults = partialResults;
    }

}

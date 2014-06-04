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
@Table(name = "area")
public class Area implements java.io.Serializable {

    private Integer id;
    private String name;
    private Set groups = new HashSet(0);

    public Area() {
    }

    public Area(String name) {
        this.name = name;
    }

    public Area(String name, Set groups) {
        this.name = name;
        this.groups = groups;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "area")
    public Set getGroups() {
        return this.groups;
    }

    public void setGroups(Set groups) {
        this.groups = groups;
    }

}

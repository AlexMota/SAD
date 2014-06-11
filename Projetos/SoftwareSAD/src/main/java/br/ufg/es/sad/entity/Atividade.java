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
@Table(name = "atividade")
public class Atividade implements java.io.Serializable {

    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Id
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grupo_id", nullable = false)
    private Grupo grupo;

    @Column(name = "nome", nullable = false, length = 45)
    private String nome;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "atividade")
    private Set<Valor> valors = new HashSet<Valor>(0);

    public Atividade() {
    }

    public Atividade(Grupo grupo, String nome) {
        this.grupo = grupo;
        this.nome = nome;
    }

    public Atividade(Grupo grupo, String nome, Set valors) {
        this.grupo = grupo;
        this.nome = nome;
        this.valors = valors;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Grupo getGrupo() {
        return this.grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Valor> getValors() {
        return this.valors;
    }

    public void setValors(Set<Valor> valors) {
        this.valors = valors;
    }

}

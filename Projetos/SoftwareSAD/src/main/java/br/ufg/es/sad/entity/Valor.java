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
@Table(name = "valor")
public class Valor implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "valor", nullable = false, precision = 2, scale = 0)
    private byte valor;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "valor")
    private Set<AtividadeResolucao> atividadeResolucaos = new HashSet<AtividadeResolucao>(0);

    public Valor() {
    }

    public Valor(byte valor) {
        this.valor = valor;
    }

    public Valor(byte valor, Set<AtividadeResolucao> atividadeResolucaos) {
        this.valor = valor;
        this.atividadeResolucaos = atividadeResolucaos;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte getValor() {
        return this.valor;
    }

    public void setValor(byte valor) {
        this.valor = valor;
    }

    public Set<AtividadeResolucao> getAtividadeResolucaos() {
        return this.atividadeResolucaos;
    }

    public void setAtividadeResolucaos(Set<AtividadeResolucao> atividadeResolucaos) {
        this.atividadeResolucaos = atividadeResolucaos;
    }

}

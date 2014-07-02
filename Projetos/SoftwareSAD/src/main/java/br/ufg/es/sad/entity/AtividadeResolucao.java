package br.ufg.es.sad.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entidade que define o relacionamento das entidades <code>Resolucao</code> e
 * <code>Atividade</code>
 *
 * @author Phelipe Alves de Souza
 * @since 02/07/2014
 * @version 0.1
 */
@Entity
@Table(name = AtividadeResolucao.NAME)
@AssociationOverrides({
    @AssociationOverride(name = AtividadeResolucao.ATIVIDADE,
            joinColumns = @JoinColumn(name = "atividade_id")),
    @AssociationOverride(name = AtividadeResolucao.RESOLUCAO,
            joinColumns = @JoinColumn(name = "resolucao_id"))})
public class AtividadeResolucao implements java.io.Serializable {

    public static final String NAME = "atividade_resolucao";
    public static final String ATIVIDADE = "pk.atividade";
    public static final String RESOLUCAO = "pk.resolucao";

    @EmbeddedId
    private AtividadeResolucaoId pk = new AtividadeResolucaoId();

    @Column(name = "valor", nullable = false, precision = 2, scale = 0)
    private double valor;

    public AtividadeResolucao() {
    }

    public AtividadeResolucao(Atividade atividade, Resolucao resolucao, double valor) {
        setAtividade(atividade);
        setResolucao(resolucao);
        setValor(valor);
    }

    public AtividadeResolucaoId getPk() {
        return this.pk;
    }

    public void setPk(AtividadeResolucaoId id) {
        this.pk = id;
    }

    @Transient
    public Resolucao getResolucao() {
        return getPk().getResolucao();
    }

    public void setResolucao(Resolucao resolucao) {
        getPk().setResolucao(resolucao);
    }

    @Transient
    public Atividade getAtividade() {
        return getPk().getAtividade();
    }

    public void setAtividade(Atividade atividade) {
        getPk().setAtividade(atividade);
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Resolucao: " + getResolucao().toString() + " Atividade: " + getAtividade().toString() + " Valor: " + valor;
    }

    @Override
    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AtividadeResolucao other = (AtividadeResolucao) obj;
        if (this.pk != other.pk && (this.pk == null || !this.pk.equals(other.pk))) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        return true;
    }

}

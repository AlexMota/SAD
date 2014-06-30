package br.ufg.es.sad.entity;

import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * http://www.mkyong.com/hibernate/hibernate-many-to-many-example-join-table-extra-column-annotation/
 * @author phelipe
 */
@Entity
@Table(name = AtividadeResolucao.NAME)
public class AtividadeResolucao implements java.io.Serializable {

    public static final String NAME = "atividade_resolucao";

    @EmbeddedId
    private AtividadeResolucaoId id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "resolucao_id", nullable = false, insertable = false, updatable = false)
    private Resolucao resolucao;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "atividade_id", nullable = false, insertable = false, updatable = false)
    private Atividade atividade;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    public AtividadeResolucao() {
    }

    public AtividadeResolucao(Resolucao resolucao, Atividade atividade, double valor) {
        this.resolucao = resolucao;
        this.atividade = atividade;
        this.valor = new BigDecimal(valor);
    }

    public AtividadeResolucao(AtividadeResolucaoId id, Resolucao resolucao, Atividade atividade, double valor) {
        this.id = id;
        this.resolucao = resolucao;
        this.atividade = atividade;
        this.valor = new BigDecimal(valor);
    }

    @AttributeOverrides({
        @AttributeOverride(name = "atividadeId", column = @Column(name = "atividade_id", nullable = false)),
        @AttributeOverride(name = "resolucaoId", column = @Column(name = "resolucao_id", nullable = false))})
    @Id
    public AtividadeResolucaoId getId() {
        return this.id;
    }

    public void setId(AtividadeResolucaoId id) {
        this.id = id;
    }

    public Resolucao getResolucao() {
        return this.resolucao;
    }

    public void setResolucao(Resolucao resolucao) {
        this.resolucao = resolucao;
    }

    public Atividade getAtividade() {
        return this.atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}

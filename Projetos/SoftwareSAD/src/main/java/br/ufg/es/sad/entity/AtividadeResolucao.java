package br.ufg.es.sad.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "atividade_resolucao")
public class AtividadeResolucao implements java.io.Serializable {

    private AtividadeResolucaoId id;
    private Resolucao resolucao;
    private Valor valor;
    private Atividade atividade;

    public AtividadeResolucao() {
    }

    public AtividadeResolucao(AtividadeResolucaoId id, Resolucao resolucao, Valor valor, Atividade atividade) {
        this.id = id;
        this.resolucao = resolucao;
        this.valor = valor;
        this.atividade = atividade;
    }
    
    public AtividadeResolucao(Resolucao resolucao, Valor valor, Atividade atividade) {        
        this.resolucao = resolucao;
        this.valor = valor;
        this.atividade = atividade;
    }

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "atividadeId", column = @Column(name = "atividade_id", nullable = false)),
        @AttributeOverride(name = "resolucaoId", column = @Column(name = "resolucao_id", nullable = false)),
        @AttributeOverride(name = "valorId", column = @Column(name = "valor_id", nullable = false))})
    public AtividadeResolucaoId getId() {
        return this.id;
    }

    public void setId(AtividadeResolucaoId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resolucao_id", nullable = false, insertable = false, updatable = false)
    public Resolucao getResolucao() {
        return this.resolucao;
    }

    public void setResolucao(Resolucao resolucao) {
        this.resolucao = resolucao;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "valor_id", nullable = false, insertable = false, updatable = false)
    public Valor getValor() {
        return this.valor;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "atividade_id", nullable = false, insertable = false, updatable = false)
    public Atividade getAtividade() {
        return this.atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

}

package br.ufg.es.sad.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AtividadeResolucaoId implements java.io.Serializable {

    @Column(name = "atividade_id", nullable = false)
    private int atividadeId;

    @Column(name = "resolucao_id", nullable = false)
    private int resolucaoId;

    @Column(name = "valor_id", nullable = false)
    private int valorId;

    public AtividadeResolucaoId() {
    }

    public AtividadeResolucaoId(int atividadeId, int resolucaoId, int valorId) {
        this.atividadeId = atividadeId;
        this.resolucaoId = resolucaoId;
        this.valorId = valorId;
    }

    public int getAtividadeId() {
        return this.atividadeId;
    }

    public void setAtividadeId(int atividadeId) {
        this.atividadeId = atividadeId;
    }

    public int getResolucaoId() {
        return this.resolucaoId;
    }

    public void setResolucaoId(int resolucaoId) {
        this.resolucaoId = resolucaoId;
    }

    public int getValorId() {
        return this.valorId;
    }

    public void setValorId(int valorId) {
        this.valorId = valorId;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof AtividadeResolucaoId)) {
            return false;
        }
        AtividadeResolucaoId castOther = (AtividadeResolucaoId) other;

        return (this.getAtividadeId() == castOther.getAtividadeId())
                && (this.getResolucaoId() == castOther.getResolucaoId())
                && (this.getValorId() == castOther.getValorId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getAtividadeId();
        result = 37 * result + this.getResolucaoId();
        result = 37 * result + this.getValorId();
        return result;
    }

}

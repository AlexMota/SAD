package br.ufg.es.sad.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * http://www.mkyong.com/hibernate/hibernate-many-to-many-example-join-table-extra-column-annotation/
 * @author phelipe
 */
@Embeddable
public class AtividadeResolucaoId implements java.io.Serializable {

    @Column(name = "atividade_id", nullable = false)
    private int atividadeId;

    @Column(name = "resolucao_id", nullable = false)
    private int resolucaoId;

    public AtividadeResolucaoId() {
    }

    public AtividadeResolucaoId(int atividadeId, int resolucaoId) {
        this.atividadeId = atividadeId;
        this.resolucaoId = resolucaoId;
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
                && (this.getResolucaoId() == castOther.getResolucaoId());
    }
}

package br.ufg.es.sad.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * Entidade que é definida como identificador do realicionamento m x n entre as
 * entidades: <code>Atividade</code> e <code>Resolucao</code>.<br>
 * Essa entidade irá compor a entidade <code>AtividadeResolucao<code>.
 *
 * @author Phelipe Alves de Souza
 * @since 02/07/2014
 * @version 0.1
 */
@Embeddable
public class AtividadeResolucaoId implements java.io.Serializable {

    @ManyToOne
    private Atividade atividade;

    @ManyToOne
    private Resolucao resolucao;

    public AtividadeResolucaoId() {
    }

    public AtividadeResolucaoId(Atividade atividade, Resolucao resolucao) {
        this.atividade = atividade;
        this.resolucao = resolucao;
    }

    public Atividade getAtividade() {
        return this.atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Resolucao getResolucao() {
        return this.resolucao;
    }

    public void setResolucao(Resolucao resolucao) {
        this.resolucao = resolucao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.atividade != null ? this.atividade.hashCode() : 0);
        hash = 97 * hash + (this.resolucao != null ? this.resolucao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AtividadeResolucaoId other = (AtividadeResolucaoId) obj;
        if (this.atividade != other.atividade && (this.atividade == null || !this.atividade.equals(other.atividade))) {
            return false;
        }
        if (this.resolucao != other.resolucao && (this.resolucao == null || !this.resolucao.equals(other.resolucao))) {
            return false;
        }
        return true;
    }

}

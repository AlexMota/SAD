package br.ufg.es.sad.persistence.dao.impl;

import br.ufg.es.sad.entity.Atividade;
import br.ufg.es.sad.persistence.dao.AtividadeDAO;

/**
 * Classe concreta que terá a implementação específica para AtividadeDAO.
 *
 * @author Phelipe Alves de Souza
 * @since 02/07/2014
 * @version 0.2
 */
public class AtividadeDAOImpl extends GenericDAOImpl<Atividade, Integer> implements AtividadeDAO {

    public AtividadeDAOImpl() {
        super(Atividade.class);
    }
}

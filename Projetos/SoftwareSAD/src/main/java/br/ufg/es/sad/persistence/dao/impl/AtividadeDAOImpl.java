package br.ufg.es.sad.persistence.dao.impl;

import br.ufg.es.sad.entity.Atividade;
import br.ufg.es.sad.persistence.HibernateDAO;
import br.ufg.es.sad.persistence.dao.AtividadeDAO;

/**
 * Classe concreta que terá a implementação específica para cada DAO.
 *
 * @author Phelipe
 */
public class AtividadeDAOImpl extends HibernateDAO<Atividade, Integer> implements AtividadeDAO {

    public AtividadeDAOImpl() {
        super(Atividade.class);
    }
}

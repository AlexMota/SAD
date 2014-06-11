package br.ufg.es.sad.persistence.dao.impl;

import br.ufg.es.sad.entity.Atividade;
import br.ufg.es.sad.persistence.HibernateDAO;
import br.ufg.es.sad.persistence.dao.IAtividadeDAO;

/**
 * Classe concreta que terá a implementação específica para cada DAO.
 *
 * @author Phelipe
 */
public class AtividadeDAO extends HibernateDAO<Atividade, Integer> implements IAtividadeDAO {

    public AtividadeDAO() {
        super(Atividade.class);
    }
}

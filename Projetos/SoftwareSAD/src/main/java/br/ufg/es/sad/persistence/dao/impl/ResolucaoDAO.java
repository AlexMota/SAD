package br.ufg.es.sad.persistence.dao.impl;

import br.ufg.es.sad.entity.Resolucao;
import br.ufg.es.sad.persistence.HibernateDAO;
import br.ufg.es.sad.persistence.dao.IResolucaoDAO;

/**
 * Classe concreta que terá a implementação específica para cada DAO.
 *
 * @author Phelipe
 */
public abstract class ResolucaoDAO extends HibernateDAO<Resolucao, Integer> implements IResolucaoDAO {

    public ResolucaoDAO() {
        super(Resolucao.class);
    }
}

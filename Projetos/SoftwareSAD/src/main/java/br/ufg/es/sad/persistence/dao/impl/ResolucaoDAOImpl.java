package br.ufg.es.sad.persistence.dao.impl;

import br.ufg.es.sad.entity.Resolucao;
import br.ufg.es.sad.persistence.HibernateDAO;
import br.ufg.es.sad.persistence.dao.ResolucaoDAO;

/**
 * Classe concreta que terá a implementação específica para cada DAO.
 *
 * @author Phelipe
 */
public class ResolucaoDAOImpl extends HibernateDAO<Resolucao, Integer> implements ResolucaoDAO {

    public ResolucaoDAOImpl() {
        super(Resolucao.class);
    }
}

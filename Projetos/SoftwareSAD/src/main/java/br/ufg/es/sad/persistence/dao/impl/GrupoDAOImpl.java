package br.ufg.es.sad.persistence.dao.impl;

import br.ufg.es.sad.entity.Grupo;
import br.ufg.es.sad.persistence.HibernateDAO;
import br.ufg.es.sad.persistence.dao.GrupoDAO;

/**
 * Classe concreta que terá a implementação específica para cada DAO.
 *
 * @author Phelipe
 */
public class GrupoDAOImpl extends HibernateDAO<Grupo, Integer> implements GrupoDAO {

    public GrupoDAOImpl() {
        super(GrupoDAO.class);
    }
}

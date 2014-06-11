package br.ufg.es.sad.persistence.dao.impl;

import br.ufg.es.sad.entity.Grupo;
import br.ufg.es.sad.persistence.HibernateDAO;
import br.ufg.es.sad.persistence.dao.IGrupoDAO;

/**
 * Classe concreta que terá a implementação específica para cada DAO.
 *
 * @author Phelipe
 */
public class GrupoDAO extends HibernateDAO<Grupo, Integer> implements IGrupoDAO {

    public GrupoDAO() {
        super(IGrupoDAO.class);
    }
}

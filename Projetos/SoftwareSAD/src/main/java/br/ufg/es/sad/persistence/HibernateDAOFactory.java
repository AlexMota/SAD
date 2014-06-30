package br.ufg.es.sad.persistence;

import br.ufg.es.sad.persistence.dao.AtividadeDAO;
import br.ufg.es.sad.persistence.dao.GrupoDAO;
import br.ufg.es.sad.persistence.dao.ResolucaoDAO;
import br.ufg.es.sad.persistence.dao.impl.AtividadeDAOImpl;
import br.ufg.es.sad.persistence.dao.impl.GrupoDAOImpl;
import br.ufg.es.sad.persistence.dao.impl.ResolucaoDAOImpl;

/**
 * Implementa os métodos do DAOFactory
 *
 * @author Phelipe
 */
class HibernateDAOFactory extends DAOFactory {

    @Override
    public GrupoDAO getGrupoDAO() {
        return new GrupoDAOImpl();
    }

    @Override
    public AtividadeDAO getAtividadeDAO() {
        return new AtividadeDAOImpl();
    }

    @Override
    public ResolucaoDAO getResolucaoDAO() {
        return new ResolucaoDAOImpl();
    }
}

package br.ufg.es.sad.persistence;

import br.ufg.es.sad.persistence.dao.IAtividadeDAO;
import br.ufg.es.sad.persistence.dao.IGrupoDAO;
import br.ufg.es.sad.persistence.dao.IResolucaoDAO;
import br.ufg.es.sad.persistence.dao.impl.AtividadeDAO;
import br.ufg.es.sad.persistence.dao.impl.GrupoDAO;
import br.ufg.es.sad.persistence.dao.impl.ResolucaoDAO;

/**
 * Implementa os métodos do DAOFactory
 *
 * @author Phelipe
 */
class HibernateDAOFactory extends DAOFactory {

    @Override
    public IGrupoDAO getGrupoDAO() {
        return new GrupoDAO();
    }

    @Override
    public IAtividadeDAO getAtividadeDAO() {
        return new AtividadeDAO();
    }

    @Override
    public IResolucaoDAO getResolucaoDAO() {
        return new ResolucaoDAO() {
        };
    }

}

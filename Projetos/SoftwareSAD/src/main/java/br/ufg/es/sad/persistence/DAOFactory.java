package br.ufg.es.sad.persistence;

import br.ufg.es.sad.persistence.dao.AtividadeDAO;
import br.ufg.es.sad.persistence.dao.GrupoDAO;
import br.ufg.es.sad.persistence.dao.ResolucaoDAO;

/**
 * Responsável por criar as instâncias das classes Hibernate
 *
 * @author Phelipe
 */
public abstract class DAOFactory {

    private static final Class FACTORY_CLASS = HibernateDAOFactory.class;
    
    /**
     * Retornar uma instância da classe
     * @return 
     */
    public static DAOFactory getFactory() {

        try {
            return (DAOFactory) FACTORY_CLASS.newInstance();

        } catch (InstantiationException e) {
            throw new RuntimeException();

        } catch (IllegalAccessException e) {
            throw new RuntimeException();
        }
    }

    public abstract GrupoDAO getGrupoDAO();
    
    public abstract AtividadeDAO getAtividadeDAO();

    public abstract ResolucaoDAO getResolucaoDAO();
}

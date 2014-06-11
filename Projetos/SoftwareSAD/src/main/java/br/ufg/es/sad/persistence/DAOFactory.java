package br.ufg.es.sad.persistence;

import br.ufg.es.sad.persistence.dao.IAtividadeDAO;
import br.ufg.es.sad.persistence.dao.IGrupoDAO;
import br.ufg.es.sad.persistence.dao.IResolucaoDAO;

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

    public abstract IGrupoDAO getGrupoDAO();

    public abstract IAtividadeDAO getAtividadeDAO();

    public abstract IResolucaoDAO getResolucaoDAO();
}

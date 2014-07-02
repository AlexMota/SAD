package br.ufg.es.sad.persistence;

import br.ufg.es.sad.persistence.dao.AtividadeDAO;
import br.ufg.es.sad.persistence.dao.GrupoDAO;
import br.ufg.es.sad.persistence.dao.ResolucaoDAO;

/**
 * Responsável por encapsular as instanciações dos tipos concretos dos DAOs.
 *
 * @author Phelipe Alves de Souza
 * @since 29/06/2014
 * @version 0.1
 */
public abstract class DAOFactory {

    private static final Class FACTORY_CLASS = HibernateDAOFactory.class;

    /**
     * Retornar uma instância de uma subclasse que implementa os elementos
     * abstratos em tipos concretos.
     *
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

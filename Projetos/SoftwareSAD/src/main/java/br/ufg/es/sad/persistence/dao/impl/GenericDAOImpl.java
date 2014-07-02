package br.ufg.es.sad.persistence.dao.impl;

import br.ufg.es.sad.persistence.util.HibernateUtil;
import br.ufg.es.sad.persistence.dao.GenericDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

/**
 * Implementaçao de <code>GenericDAO</code> utilizando Hibernate
 *
 * @author Phelipe Alves de Souza
 * @since 29/06/2014
 * @version 0.1
 * @param <T> o tipo do objeto de domínio
 * @param <Type> o tipo do identificador do objeto de dominio
 */
public abstract class GenericDAOImpl<T, Type extends Serializable> implements GenericDAO<T, Type> {

    private final Class<T> persistentClass;

    public GenericDAOImpl(Class persistentClass) {
        super();
        this.persistentClass = persistentClass;
    }

    public Session getSession() {
        return HibernateUtil.getSession();
    }

    public void beginTransaction() {
        getSession().beginTransaction();
    }

    public void commitTransaction() {
        getSession().getTransaction().commit();
    }

    public T load(Type id) throws EntityNotFoundException {
        T entity = get(id);
        if (entity == null) {
            throw new EntityNotFoundException("Entidade não encontrada");
        }
        return entity;
    }

    @Override
    public T get(Type id) throws HibernateException {
        beginTransaction();
        T entity = (T) HibernateUtil.getSession().get(persistentClass, id);
        commitTransaction();
        return entity;
    }

    @Override
    public List<T> getAll() {
        Criteria criteria = HibernateUtil.getSession().createCriteria(persistentClass);
        return criteria.list();
    }

    @Override
    public void save(T object) throws HibernateException {
        beginTransaction();
        getSession().saveOrUpdate(object);
        getSession().flush();
        commitTransaction();
    }

    public void save(List<T> objects) throws HibernateException {
        for (T object : objects) {
            save(object);
        }
    }

    @Override
    public boolean delete(T entity) throws HibernateException {
        beginTransaction();
        try {
            HibernateUtil.getSession().delete(entity);
            return true;
        } catch (HibernateException e) {
            throw new HibernateException("Erro ao deletar: " + entity.toString());
        } finally {
            commitTransaction();
        }
    }

    @Override
    public boolean deleteById(Type id) throws HibernateException {
        try {
            T object = (T) getSession().get(persistentClass, id);
            return delete(object);
        } catch (HibernateException e) {
            throw new HibernateException("Erro ao deletar: " + persistentClass.getSimpleName() + " id: " + id);
        }
    }

}

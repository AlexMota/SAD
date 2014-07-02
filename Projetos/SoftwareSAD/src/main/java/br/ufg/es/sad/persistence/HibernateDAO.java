package br.ufg.es.sad.persistence;

import br.ufg.es.sad.persistence.util.HibernateUtil;
import br.ufg.es.sad.persistence.dao.GenericDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.classic.Session;

/**
 *
 * @author Phelipe Alves de Souza
 * @since 29/06/2014
 * @version 0.1
 * @param <T>
 * @param <Type>
 */
public abstract class HibernateDAO<T, Type extends Serializable> implements GenericDAO<T, Type> {

    private final Class<T> persistentClass;

    public HibernateDAO(Class persistentClass) {
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
            throw new EntityNotFoundException("Entidade");
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
        //HibernateUtil.beginTransaction();
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

    public boolean deleteAll() throws HibernateException {
        beginTransaction();

        try {
            String hql = String.format("delete from %s", persistentClass.getSimpleName().toLowerCase());
            Query query = HibernateUtil.getSession().createQuery(hql);
            int row = query.executeUpdate();
            return true;
        } catch (HibernateException e) {
            throw new HibernateException("Erro ao deletar todos registros " + persistentClass.getSimpleName());
        } finally {
            commitTransaction();
        }
    }

}

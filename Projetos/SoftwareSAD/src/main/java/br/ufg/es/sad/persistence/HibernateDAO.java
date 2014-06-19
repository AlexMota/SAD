/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.es.sad.persistence;

import br.ufg.es.sad.persistence.dao.GenericDAO;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;

/**
 *
 * @author Phelipe
 * @param <T>
 * @param <Type>
 */
public abstract class HibernateDAO<T, Type extends Serializable> implements GenericDAO<T, Type> {

    private final Class<T> persistentClass;

    public HibernateDAO(Class persistentClass) {
        super();
        this.persistentClass = persistentClass;
    }

    @Override
    public void beginTransaction() {
        HibernateUtil.beginTransaction();
    }

    @Override
    public void commitTransaction() {
        HibernateUtil.commitTransaction();
    }

    @Override
    public void salvar(T entity) {
        HibernateUtil.getSession().saveOrUpdate(entity);
    }

    @Override
    public boolean excluir(T entity) {
        try {
            HibernateUtil.getSession().delete(entity);
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public boolean excluirId(Type id) {
        try {
            T object = (T) HibernateUtil.getSession().get(persistentClass, id);
            excluir(object);
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public List<T> listar() {
        HibernateUtil.beginTransaction();
        Criteria criteria = HibernateUtil.getSession().createCriteria(persistentClass);
        return criteria.list();
    }

}

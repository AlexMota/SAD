/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.es.sad.persistence;

import br.ufg.es.sad.persistence.dao.IGenericDAO;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;

/**
 *
 * @author Phelipe
 * @param <T>
 * @param <Type>
 */
public abstract class HibernateDAO<T, Type extends Serializable> implements IGenericDAO<T, Type> {

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
    public void excluir(T entity) {
        HibernateUtil.getSession().delete(entity);
    }

    public void excluir(Type id) {
        
    }
    
    @Override
    public List<T> listar() {
        HibernateUtil.beginTransaction();
        Criteria criteria = HibernateUtil.getSession().createCriteria(persistentClass);
        return criteria.list();
    }

}

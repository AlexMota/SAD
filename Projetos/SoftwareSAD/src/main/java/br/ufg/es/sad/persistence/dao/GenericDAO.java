package br.ufg.es.sad.persistence.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Phelipe Alves de Souza
 * @since 29/06/2014
 * @version 0.1
 * @param <T> a classe, a entidade
 * @param <Type> representa o tipo do Id da entidade
 */
public interface GenericDAO<T, Type extends Serializable> {   

    T load(Type id);

    T get(Type id);

    List<T> getAll();

    void save(T object);
    
    void save(List<T> objects);
    
    boolean delete(T object);

    boolean deleteById(Type id);

    boolean deleteAll();
}

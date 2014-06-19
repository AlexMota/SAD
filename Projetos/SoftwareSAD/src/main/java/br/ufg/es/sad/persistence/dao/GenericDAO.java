package br.ufg.es.sad.persistence.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Phelipe
 * @param <T> a classe, a entidade
 * @param <Type> representa o tipo do Id da entidade
 */
public interface GenericDAO<T , Type extends Serializable> {

    void beginTransaction();

    void commitTransaction();

    void salvar(T object);

    boolean excluir(T object);
    
    boolean excluirId(Type id);

    List<T> listar();
}

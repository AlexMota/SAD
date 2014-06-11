package br.ufg.es.sad.persistence.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Phelipe
 * @param <T> a classe, a entidade
 * @param <Type> representa o tipo do Id da entidade
 */
public interface IGenericDAO<T, Type extends Serializable> {

    void beginTransaction();

    void commitTransaction();

    void salvar(T object);

    void excluir(T object);

    List<T> listar();
}

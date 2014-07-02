package br.ufg.es.sad.persistence.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Interface para criar um DAO, que pode ser usado para um único objeto de
 * domínio de um tipo especificado. Uma única instância que implementar essa
 * interface, pode ser usada apenas para o tipo de objeto de domínio
 * especificado nos parâmetros de tipo.
 *
 * @author Phelipe Alves de Souza
 * @since 29/06/2014
 * @version 0.2
 * @param <T> o tipo do objeto de domínio
 * @param <Type> o tipo do identificador do objeto de dominio
 */
public interface GenericDAO<T, Type extends Serializable> {

    /**
     * Carrega todo objeto e suas realções, com o id especificado
     *
     * @param id
     * @return
     */
    T load(Type id);

    /**
     * Selecionar uma objeto pelo identificador
     *
     * @param id
     * @return
     */
    T get(Type id);

    /**
     * Listar todos os objetos registrados
     *
     * @return
     */
    List<T> getAll();

    /**
     * Salvar um objeto
     *
     * @param object
     */
    void save(T object);

    /**
     * Salvar uma lista de objetos
     *
     * @param objects
     */
    void save(List<T> objects);

    /**
     * Deletar um objeto
     *
     * @param object
     * @return <code> true </ code> se for removido com sucesso.
     * <code> false </ code> se não for encontrado.
     */
    boolean delete(T object);

    /**
     * Deletar um objeto pelo identificador
     *
     * @param id
     * @return <code> true </ code> se for removido com sucesso.
     * <code> false </ code> se não for encontrado.
     */
    boolean deleteById(Type id);
}

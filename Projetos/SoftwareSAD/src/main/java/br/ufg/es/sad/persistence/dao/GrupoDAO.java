package br.ufg.es.sad.persistence.dao;

import br.ufg.es.sad.entity.Grupo;
import java.util.List;

/**
 * Interface que contém os métodos específicos para Grupo.
 *
 * @author Phelipe Alves de Souza
 * @since 02/07/2014
 * @version 0.2
 */
public interface GrupoDAO extends GenericDAO<Grupo, Integer> {

    /**
     * Selecionar grupos raiz, que não fazem parte de um subgrupo
     *
     * @return lista com todos os grupos
     */
    List<Grupo> getGruposRaiz();
}

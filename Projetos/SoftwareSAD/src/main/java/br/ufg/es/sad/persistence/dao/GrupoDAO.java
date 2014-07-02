package br.ufg.es.sad.persistence.dao;

import br.ufg.es.sad.entity.Grupo;
import java.util.List;

/**
 * É nessa interface que colocamos os métodos específicos para o nosso DAO.
 *
 * @author Phelipe
 */
public interface GrupoDAO extends GenericDAO<Grupo, Integer> {

    /**
     * Selecionar grupos raiz, que não fazem parte de um subgrupo
     *
     * @return
     */
    List<Grupo> getGruposRaiz();
}

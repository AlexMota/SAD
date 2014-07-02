package br.ufg.es.sad.persistence.dao;

import br.ufg.es.sad.entity.Atividade;
import br.ufg.es.sad.entity.Resolucao;
import java.util.List;

/**
 * É nessa interface que colocamos os métodos específicos para o nosso DAO.
 *
 * @author Phelipe
 */
public interface ResolucaoDAO extends GenericDAO<Resolucao, Integer> {

    /**
     * Listar todas as atividades da resolução
     *
     * @param resolucao
     * @return lista com todas as atividades
     */
    List<Atividade> getAllAtividades(Resolucao resolucao);
}

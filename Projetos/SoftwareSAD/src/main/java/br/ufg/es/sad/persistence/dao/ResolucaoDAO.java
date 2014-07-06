package br.ufg.es.sad.persistence.dao;

import br.ufg.es.sad.entity.Atividade;
import br.ufg.es.sad.entity.AtividadeResolucao;
import br.ufg.es.sad.entity.Resolucao;
import java.util.List;

/**
 * Interface que contém os métodos específicos para Resolucao.
 *
 * @author Phelipe Alves de Souza
 * @since 02/07/2014
 * @version 0.2
 */
public interface ResolucaoDAO extends GenericDAO<Resolucao, Integer> {

    /**
     * Listar todas as atividades da resolução
     *
     * @param resolucao
     * @return lista com todas as atividades
     */
    List<Atividade> getAllAtividades(Resolucao resolucao);
    
    List<AtividadeResolucao> getAllAtividadeResolucao(int resolucaoId);
}

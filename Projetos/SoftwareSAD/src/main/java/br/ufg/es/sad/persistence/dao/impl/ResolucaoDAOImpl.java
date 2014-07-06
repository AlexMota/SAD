package br.ufg.es.sad.persistence.dao.impl;

import br.ufg.es.sad.entity.Atividade;
import br.ufg.es.sad.entity.AtividadeResolucao;
import br.ufg.es.sad.entity.Resolucao;
import br.ufg.es.sad.persistence.dao.ResolucaoDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

/**
 * Classe concreta que terá a implementação específica para ResolucaoDAO.
 *
 * @author Phelipe Alves de Souza
 * @since 02/07/2014
 * @version 0.2
 */
public class ResolucaoDAOImpl extends GenericDAOImpl<Resolucao, Integer> implements ResolucaoDAO {

    public ResolucaoDAOImpl() {
        super(Resolucao.class);
    }

    @Override
    public List<Atividade> getAllAtividades(Resolucao resolucao) {
        if (resolucao == null) {
            return null;
        } else {
            List<AtividadeResolucao> atr = getAllAtividadeResolucao(resolucao.getId());
            List<Atividade> atividades = new ArrayList<Atividade>();
            for (AtividadeResolucao atividadeResolucao : atr) {
                atividades.add(atividadeResolucao.getAtividade());
            }
            return atividades;
        }
    }

    public List<AtividadeResolucao> getAllAtividadeResolucao(int resolucaoId) {
        Criteria crit = getSession().createCriteria(Resolucao.class);
        crit.setFetchMode("atividadesResolucao", FetchMode.SELECT);
        crit.add(Restrictions.idEq(resolucaoId)).uniqueResult();

        Resolucao resolucao = (Resolucao) crit.uniqueResult();
        List<AtividadeResolucao> resul = new ArrayList<AtividadeResolucao>();
        resul.addAll(resolucao.getAtividadeResolucaos());
        return resul;
    }
}

package br.ufg.es.sad.persistence.dao.impl;

import br.ufg.es.sad.entity.AtividadeResolucao;
import br.ufg.es.sad.entity.Resolucao;
import br.ufg.es.sad.persistence.dao.ResolucaoDAO;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
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

    public Set<AtividadeResolucao> getAllAtividades(Resolucao resolucao) {
        if (resolucao == null) {
            return null;
        } else {
            Hibernate.initialize(resolucao);
            return resolucao.getAtividadeResolucaos();
        }
    }

    public Resolucao loadComplete(Integer id) {
        Criteria criteria = getSession().createCriteria(Resolucao.class);
        Resolucao resolucao = (Resolucao) criteria.add(Restrictions.idEq(id)).uniqueResult();
        Hibernate.initialize(resolucao);
        return resolucao;
    }
}

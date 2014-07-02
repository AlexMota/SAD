package br.ufg.es.sad.persistence.dao.impl;

import br.ufg.es.sad.entity.Atividade;
import br.ufg.es.sad.entity.Resolucao;
import br.ufg.es.sad.persistence.HibernateDAO;
import br.ufg.es.sad.persistence.dao.ResolucaoDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * Classe concreta que terá a implementação específica para cada DAO.
 *
 * @author Phelipe
 */
public class ResolucaoDAOImpl extends HibernateDAO<Resolucao, Integer> implements ResolucaoDAO {

    public ResolucaoDAOImpl() {
        super(Resolucao.class);
    }

    public List<Atividade> getAllAtividades(Resolucao resolucao) {
        Criteria criteria = getSession().createCriteria(resolucao.getClass());
        criteria.add(Restrictions.eq("", ""));
        return null;
    }
}
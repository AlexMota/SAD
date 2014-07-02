package br.ufg.es.sad.persistence.dao.impl;

import br.ufg.es.sad.entity.Grupo;
import br.ufg.es.sad.persistence.HibernateDAO;
import br.ufg.es.sad.persistence.dao.GrupoDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * Classe concreta que terá a implementação específica para cada DAO.
 *
 * @author Phelipe
 */
public class GrupoDAOImpl extends HibernateDAO<Grupo, Integer> implements GrupoDAO {

    public GrupoDAOImpl() {
        super(Grupo.class);
    }

    @Override
    public List<Grupo> getGruposRaiz() {
        Criteria crit = getSession().createCriteria(Grupo.class, "grupo");
        crit.add(Restrictions.eq("grupo.grupo_id", 16));
        return crit.list();
    }
}

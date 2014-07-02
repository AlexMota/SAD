package br.ufg.es.sad.persistence.dao.impl;

import br.ufg.es.sad.entity.Grupo;
import br.ufg.es.sad.persistence.dao.GrupoDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

/**
 * Classe concreta que terá a implementação específica para cada GrupoDAO.
 *
 * @author Phelipe Alves de Souza
 * @since 02/07/2014
 * @version 0.2
 */
public class GrupoDAOImpl extends GenericDAOImpl<Grupo, Integer> implements GrupoDAO {

    public GrupoDAOImpl() {
        super(Grupo.class);
    }

    @Override
    public List<Grupo> getGruposRaiz() {
        Criteria crit = getSession().createCriteria(Grupo.class);
        crit.setFetchMode("grupos", FetchMode.SELECT);
        crit.add(Restrictions.isNull("grupo"));
        return crit.list();
    }
}

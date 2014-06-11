package test.br.ufg.es.sad.entity.dao;

import br.ufg.es.sad.entity.Resolucao;
import br.ufg.es.sad.persistence.dao.impl.ResolucaoDaoImpl;
import junit.framework.TestCase;

public class ResolucaoTest
        extends TestCase {

    public ResolucaoTest() {
        create();
    }

    public void create() {
        Resolucao resolucao = new Resolucao(null, null, null);
        ResolucaoDaoImpl dao = new ResolucaoDaoImpl();
        dao.create(resolucao);

        assertEquals(new Integer(1), resolucao.getId());
    }
}

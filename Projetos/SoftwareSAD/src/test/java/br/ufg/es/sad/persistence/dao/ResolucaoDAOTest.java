package br.ufg.es.sad.persistence.dao;

import br.ufg.es.sad.entity.Atividade;
import br.ufg.es.sad.entity.Resolucao;
import br.ufg.es.sad.persistence.DAOFactory;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

/**
 * http://www.adufg.org.br/dados/editor3/file/Resolucao_CONSUNI_2013_0032.pdf
 *
 * @author Phelipe Alves de Souza
 * @since 29/06/2014
 * @version 0.1
 */
public class ResolucaoDAOTest extends TestCase {

    ResolucaoDAO dao;

    public ResolucaoDAOTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.out.println("* iniciando: " + this.getClass().getName());
        DAOFactory factory = DAOFactory.getFactory();
        dao = factory.getResolucaoDAO();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        System.out.println("* finalizado: " + this.getClass().getName());
    }

    public void testDao() {
        assertNotNull(dao);
    }

    public void testSave() {
        Resolucao resolucao = new Resolucao("Resolucao 2014-02");

        dao.save(resolucao);

        assertTrue(resolucao.getId() > 0);

        Resolucao persistido = dao.get(resolucao.getId());

        assertNotNull(persistido);
        assertEquals(persistido, resolucao);
    }

    public void testSaveList() {
        List<Resolucao> resolucoes = getListResolucoes();

        dao.save(resolucoes);

        for (Resolucao resolucao : resolucoes) {
            assertTrue(resolucao.getId() > 0);
        }
    }

    public void testGetById() {
        Resolucao grupo = new Resolucao("Resolucao 3330-09");
        dao.save(grupo);
        assertTrue(grupo.getId() > 0);

        Resolucao persistido = dao.get(grupo.getId());

        assertNotNull(persistido);
        assertEquals(persistido, grupo);
    }

    public void testGetAll() {
        dao.save(getListResolucoes());

        List<Resolucao> resolucao = dao.getAll();
        assertNotNull(resolucao);
        assertFalse(resolucao.isEmpty());
    }

    public void testDelete() {
        Resolucao resolucao = new Resolucao("Resolucao 2209-12");
        dao.save(resolucao);

        boolean deleted = dao.delete(resolucao);

        assertTrue(deleted);
    }

    public void testDeleteById() {
        Resolucao resolucao = new Resolucao("Resolucao 1003-09");
        dao.save(resolucao);

        boolean deleted = dao.deleteById(resolucao.getId());
        assertTrue(deleted);
    }

    public void testDeleteAll() {
        dao.save(getListResolucoes());

        boolean deleted = dao.deleteAll();

        assertTrue(deleted);
    }

    private List<Resolucao> getListResolucoes() {
        List<Resolucao> grupos = new ArrayList<Resolucao>();
        grupos.add(new Resolucao("Resolucao 2012-01"));
        grupos.add(new Resolucao("Resolucao 2012-03"));
        grupos.add(new Resolucao("Resolucao 2014-01"));
        grupos.add(new Resolucao("Resolucao 2015-01"));
        return grupos;
    }

    public void testResolucaoDefault() {
        final Resolucao resolucao = getResolucaoDefault();

        dao.save(resolucao);

        Resolucao persisted = dao.get(resolucao.getId());
        assertNotNull(persisted);
        assertEquals(persisted, resolucao);
    }

    private Resolucao getResolucaoDefault() {
        final Resolucao resolucao = new Resolucao("Resolucao 2014");
        return resolucao;
    }
    
    public void testAddAtividadeResolucao() {
        Resolucao resolucao = new Resolucao("Resolucao com atividade 01");
        dao.save(resolucao);
        
        
        resolucao.addAtividade(new Atividade("Atividade da resolução"), 2.5);
        
        dao.save(resolucao);
        
        Resolucao persisted = dao.get(resolucao.getId());
        assertNotNull(persisted);
        assertEquals(persisted, resolucao);
    }
}

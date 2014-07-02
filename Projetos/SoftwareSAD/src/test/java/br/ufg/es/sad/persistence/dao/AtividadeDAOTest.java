package br.ufg.es.sad.persistence.dao;

import br.ufg.es.sad.entity.Atividade;
import br.ufg.es.sad.entity.Resolucao;
import br.ufg.es.sad.persistence.DAOFactory;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import org.hibernate.HibernateException;

/**
 *
 * @author Phelipe Alves de Souza
 * @since 29/06/2014
 * @version 0.1
 */
public class AtividadeDAOTest extends TestCase {

    AtividadeDAO dao;
    Resolucao resolucao;

    public AtividadeDAOTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.out.println("Iniciando: " + getClass().getSimpleName());

        DAOFactory factory = DAOFactory.getFactory();
        dao = factory.getAtividadeDAO();

        resolucao = new Resolucao("Resolução " + getClass().getSimpleName());
        factory.getResolucaoDAO().save(resolucao);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        System.out.println("Finalizando: " + getClass().getSimpleName());
    }

    public void testDao() {
        assertNotNull(dao);
    }
    
    public void testResolucao() {
        assertNotNull(resolucao);
    }

    public void testSave() throws HibernateException {
        Atividade atividade = new Atividade("Docente regularmente matriculado em curso de doutorado com relatórios de pós-graduação aprovados (pontuação por mês de curso)", resolucao, 10);

        dao.save(atividade);

        assertTrue(atividade.getId() > 0);

        Atividade persistido = dao.get(atividade.getId());

        assertNotNull(persistido);
        assertEquals(persistido, atividade);
    }

    public void testSaveList() throws HibernateException {
        List<Atividade> atividades = getListAtividade();

        dao.save(atividades);

        for (Atividade atividade : atividades) {
            assertTrue(atividade.getId() > 0);
        }
    }

    public void testGetById() throws HibernateException {
        Atividade atividade = new Atividade("Iniciação cientifica", resolucao, 10);
        dao.save(atividade);
        assertTrue(atividade.getId() > 0);

        Atividade persistido = dao.get(atividade.getId());

        assertNotNull(persistido);
        assertEquals(persistido, atividade);
    }

    public void testGetAll() throws HibernateException {
        dao.save(getListAtividade());

        List<Atividade> atividades = dao.getAll();
        assertNotNull(atividades);
        assertFalse(atividades.isEmpty());
    }

    public void testDelete() throws HibernateException {
        Atividade atividade = new Atividade("Publicadas em revistas científicas", resolucao, 10);
        dao.save(atividade);

        boolean deleted = dao.delete(atividade);
        
        assertTrue(deleted);
    }

    public void testDeleteById() throws HibernateException {
        Atividade atividade = new Atividade("Publicadas em revistas científicas", resolucao, 10);
        dao.save(atividade);

        boolean deleted = dao.deleteById(atividade.getId());

        assertTrue(deleted);
    }

    public void testDeleteAll() throws HibernateException {
        dao.save(getListAtividade());

        boolean deleted = dao.deleteAll();

        assertTrue(deleted);
    }

    private List<Atividade> getListAtividade() {
        List<Atividade> atividades = new ArrayList<Atividade>();
        atividades.add(new Atividade("Membro de banca de concurso para docente efetivo", resolucao, 10));
        atividades.add(new Atividade("Em outra instituição", resolucao, 10));
        atividades.add(new Atividade("Membro de banca de concurso para docente substituto", resolucao, 10));
        atividades.add(new Atividade("Membro de corpo de júri", resolucao, 10));

        return atividades;
    }
}
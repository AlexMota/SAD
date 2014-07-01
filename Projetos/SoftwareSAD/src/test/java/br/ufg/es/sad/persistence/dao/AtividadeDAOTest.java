package br.ufg.es.sad.persistence.dao;

import br.ufg.es.sad.entity.Atividade;
import br.ufg.es.sad.entity.Grupo;
import br.ufg.es.sad.entity.Resolucao;
import br.ufg.es.sad.persistence.DAOFactory;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import org.hibernate.HibernateException;

/**
 * http://www.adufg.org.br/dados/editor3/file/Resolucao_CONSUNI_2013_0032.pdf
 *
 * @author Phelipe Alves de Souza
 * @since 29/06/2014
 * @version 0.1
 */
public class AtividadeDAOTest extends TestCase {

    AtividadeDAO dao;

    public AtividadeDAOTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.out.println("* iniciando: TestAtividadeDao");
        DAOFactory factory = DAOFactory.getFactory();
        dao = factory.getAtividadeDAO();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testDao() {
        assertNotNull(dao);
    }

    public void testSave() throws HibernateException {
        Atividade atividade = new Atividade("Docente regularmente matriculado em curso de doutorado com relatórios de pós-graduação aprovados (pontuação por mês de curso)");

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
        Atividade atividade = new Atividade("Iniciação cientifica");
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
        Atividade atividade = new Atividade("Publicadas em revistas científicas");
        dao.save(atividade);

        boolean deleted = dao.delete(atividade);

        assertTrue(deleted);
    }

    public void testDeleteById() throws HibernateException {
        Atividade atividade = new Atividade("Publicadas em revistas científicas");
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
        atividades.add(new Atividade("Membro de banca de concurso para docente efetivo"));
        atividades.add(new Atividade("Em outra instituição"));
        atividades.add(new Atividade("Membro de banca de concurso para docente substituto"));
        atividades.add(new Atividade("Membro de corpo de júri"));

        return atividades;
    }
}

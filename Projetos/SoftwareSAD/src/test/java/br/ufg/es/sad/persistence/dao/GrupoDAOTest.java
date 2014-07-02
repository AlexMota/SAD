package br.ufg.es.sad.persistence.dao;

import br.ufg.es.sad.entity.Grupo;
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
public class GrupoDAOTest extends TestCase {

    GrupoDAO dao;
    Resolucao resolucao;

    public GrupoDAOTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.out.println("Iniciando: " + getClass().getSimpleName());

        DAOFactory factory = DAOFactory.getFactory();
        dao = factory.getGrupoDAO();
        resolucao = new Resolucao("Resolução " + getClass().getSimpleName());
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
        Grupo grupo = new Grupo(resolucao, "V - 2 Atividades Acadêmicas – Bancas e Cursos");

        dao.save(grupo);
        System.out.println(grupo.toString());

        assertTrue(grupo.getId() > 0);

        Grupo persistido = dao.get(grupo.getId());

        assertNotNull(persistido);
        assertEquals(persistido, grupo);
    }

    public void testSaveList() {
        List<Grupo> grupos = getListGrupos();

        dao.save(grupos);

        for (Grupo grupo : grupos) {
            assertTrue(grupo.getId() > 0);
        }
    }

    public void testGetById() throws HibernateException {
        Grupo grupo = new Grupo(resolucao, "Iniciação cientifica");
        dao.save(grupo);
        assertTrue(grupo.getId() > 0);

        Grupo persistido = dao.get(grupo.getId());

        assertNotNull(persistido);
        assertEquals(persistido, grupo);
    }

    public void testGetAll() throws HibernateException {
        dao.save(getListGrupos());

        List<Grupo> grupo = dao.getAll();
        assertNotNull(grupo);
        assertFalse(grupo.isEmpty());
    }

    public void testDelete() throws HibernateException {
        Grupo grupo = new Grupo(resolucao, "Publicadas em revistas científicas");
        dao.save(grupo);

        boolean deleted = dao.delete(grupo);

        assertTrue(deleted);
    }

    public void testDeleteById() throws HibernateException {
        Grupo grupo = new Grupo(resolucao, "Publicadas em revistas científicas");
        dao.save(grupo);

        boolean deleted = dao.deleteById(grupo.getId());

        assertTrue(deleted);
    }

    public void testDeleteAll() throws HibernateException {
        dao.save(getListGrupos());

        boolean deleted = dao.deleteAll();

        assertTrue(deleted);
    }

    private List<Grupo> getListGrupos() {
        List<Grupo> grupos = new ArrayList<Grupo>();

        Grupo grupo_a = new Grupo(resolucao, "IV - ATIVIDADES ADMINISTRATIVAS E DE REPRESENTAÇÃO");
        Grupo grupo_a1 = new Grupo(resolucao, grupo_a, "IV – 1 Direção e Função Gratificada ");
        Grupo grupo_a2 = new Grupo(resolucao, grupo_a, "IV – 2 Atividades Administrativas");
        grupos.add(grupo_a1);
        grupos.add(grupo_a2);

        Grupo grupo_b = new Grupo(resolucao, "PRODUÇÃO INTELECTUAL (Anexo II)");
        Grupo grupo_b1 = new Grupo(resolucao, grupo_b, "Ensino de graduação");
        Grupo grupo_b2 = new Grupo(resolucao, grupo_b, "Produção Científica");
        Grupo grupo_b3 = new Grupo(resolucao, grupo_b, "Produção Técnica ou Tecnológica");
        Grupo grupo_b4 = new Grupo(resolucao, grupo_b, "Outro Tipo de Produção");

        grupos.add(grupo_b1);
        grupos.add(grupo_b2);
        grupos.add(grupo_b3);
        grupos.add(grupo_b4);

        return grupos;
    }

}

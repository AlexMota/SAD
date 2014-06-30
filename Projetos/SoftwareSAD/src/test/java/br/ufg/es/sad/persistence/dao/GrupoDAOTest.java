package br.ufg.es.sad.persistence.dao;

import br.ufg.es.sad.entity.Grupo;
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
public class GrupoDAOTest extends TestCase {

    GrupoDAO dao;

    public GrupoDAOTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.out.println("* iniciando: GrupoDAOTest");
        DAOFactory factory = DAOFactory.getFactory();
        dao = factory.getGrupoDAO();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        System.out.println("* finalizado: GrupoDAOTest");
    }

    public void testDao() {
        assertNotNull(dao);
    }

    public void testSave() {
        Grupo grupo = new Grupo("V - 2 Atividades Acadêmicas – Bancas e Cursos");

        dao.save(grupo);

        assertTrue(grupo.getId() > 0);

        Grupo persistido = dao.get(grupo.getId());

        assertNotNull(persistido);
        assertEquals(persistido, grupo);
    }

    public void testSaveList() {
        List<Grupo> grupos = getListGrupos();

        dao.save(grupos);

        for (Grupo atividade : grupos) {
            assertTrue(atividade.getId() > 0);
        }
    }

    public void testGetById() {
        Grupo grupo = new Grupo("Iniciação cientifica");
        dao.save(grupo);
        assertTrue(grupo.getId() > 0);

        Grupo persistido = dao.get(grupo.getId());

        assertNotNull(persistido);
        assertEquals(persistido, grupo);
    }

    public void testGetAll() {
        dao.save(getListGrupos());

        List<Grupo> grupo = dao.getAll();
        assertNotNull(grupo);
        assertFalse(grupo.isEmpty());
    }

    public void testDelete() {
        Grupo grupo = new Grupo("Publicadas em revistas científicas");
        dao.save(grupo);

        boolean deleted = dao.delete(grupo);

        assertTrue(deleted);
    }

    public void testDeleteById() {
        Grupo grupo = new Grupo("Publicadas em revistas científicas");
        dao.save(grupo);

        boolean deleted = dao.deleteById(grupo.getId());

        assertTrue(deleted);
    }

    public void testDeleteAll() {
        dao.save(getListGrupos());

        boolean deleted = dao.deleteAll();

        assertTrue(deleted);
    }

    private List<Grupo> getListGrupos() {
        List<Grupo> grupos = new ArrayList<Grupo>();
        
        Grupo grupo_a = new Grupo("ATIVIDADES DE ENSINO (Anexo II)");        
        Grupo grupo_a1 = new Grupo("Ensino de graduação", grupo_a);
        Grupo grupo_a2 = new Grupo("Ensino de pós-graduação", grupo_a);
        grupos.add(grupo_a1);
        grupos.add(grupo_a2);
        
        Grupo grupo_b = new Grupo("PRODUÇÃO INTELECTUAL (Anexo II)");        
        Grupo grupo_b1 = new Grupo("Ensino de graduação", grupo_b);
        Grupo grupo_b2 = new Grupo("Produção Científica", grupo_b);
        Grupo grupo_b3 = new Grupo("Produção Técnica ou Tecnológica", grupo_b);
        Grupo grupo_b4 = new Grupo("Outro Tipo de Produção", grupo_b);
        grupos.add(grupo_b1);
        grupos.add(grupo_b2);
        grupos.add(grupo_b3);
        grupos.add(grupo_b4);

        return grupos;
    }

    public void testAtividadeDefault() {
        Grupo grupo = getGrupoDefault();

        dao.save(grupo);

        Grupo persisted = dao.get(grupo.getId());
        assertNotNull(persisted);
        assertEquals(persisted, grupo);
    }

    private Grupo getGrupoDefault() {
        Resolucao resolucao = new Resolucao("Resolucao 2014");
        Grupo grupo = new Grupo("V - 2 Atividades Acadêmicas – Bancas e Cursos ", resolucao);        
        return grupo;
    }
}

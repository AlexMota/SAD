
import br.ufg.es.sad.entity.Atividade;
import br.ufg.es.sad.entity.AtividadeResolucao;
import br.ufg.es.sad.entity.Grupo;
import br.ufg.es.sad.entity.Resolucao;
import br.ufg.es.sad.persistence.DAOFactory;
import br.ufg.es.sad.persistence.util.HibernateUtil;
import br.ufg.es.sad.persistence.dao.AtividadeDAO;
import br.ufg.es.sad.persistence.dao.ResolucaoDAO;
import java.util.Iterator;
import java.util.List;

public class ResolucaoTest {

    public static void main(String[] args) {
        //test_ResolucaoTest_Criar();
        //test_ResolucaoTest_Listar();
        //test_ResolucaoTest_Excluir();
        //test_ResolucaoTest_Listar();
        //test_ResolucaoTest_AdicionarGrupo();
        test_ResolucaoTest_AdicionarAtivade();
    }

    public static void test_ResolucaoTest_Criar() {
        System.err.println(" ************ Cria Resolução ************ ");
        Resolucao resolucao_1 = new Resolucao("Ano 1");
        Resolucao resolucao_2 = new Resolucao("Ano 2");
        Resolucao resolucao_3 = new Resolucao("Ano 3");

        DAOFactory factory = DAOFactory.getFactory();
        ResolucaoDAO resolucaoDAO = factory.getResolucaoDAO();

        resolucaoDAO.save(resolucao_1);
        resolucaoDAO.save(resolucao_2);
        resolucaoDAO.save(resolucao_3);
    }

    public static void test_ResolucaoTest_Excluir() {
        System.err.println(" ************ Excluir ************ ");
        DAOFactory factory = DAOFactory.getFactory();
        ResolucaoDAO resolucaoDAO = factory.getResolucaoDAO();

        boolean exluido = resolucaoDAO.deleteById(new Integer(1));
        System.err.println("Exluido: 1 -> " + exluido);
    }

    public static void test_ResolucaoTest_Listar() {
        System.err.println(" ************ Listar ************ ");
        DAOFactory factory = DAOFactory.getFactory();
        ResolucaoDAO resolucaoDAO = factory.getResolucaoDAO();

        List a = resolucaoDAO.getAll();
        for (Iterator it = a.iterator(); it.hasNext();) {
            Resolucao resolucao = (Resolucao) it.next();
            System.err.println(resolucao.toString());
        }
    }

    public static void test_ResolucaoTest_AdicionarGrupo() {
        System.err.println(" ************ Adiciona Grupo na Resolução ************ ");
        DAOFactory factory = DAOFactory.getFactory();
        ResolucaoDAO resolucaoDAO = factory.getResolucaoDAO();

        Resolucao resolucao = new Resolucao("Ano com grupo");
        resolucao.addGrupo(new Grupo("ATIVIDADES DE ENSINO"));
        resolucao.addGrupo(new Grupo("PRODUÇÃO INTELECTUAL"));
        resolucao.addGrupo(new Grupo("ATIVIDADES DE PESQUISA E EXTENSÃO"));
        resolucao.addGrupo(new Grupo("ATIVIDADES ADMINISTRATIVAS E DE REPRESENTAÇÃO"));

        resolucaoDAO.save(resolucao);

        if (resolucao.getGrupos().size() == 4) {
            for (Grupo grupo : resolucao.getGrupos()) {
                System.out.println(grupo.toString());
            }
        } else {
            System.err.println("Erro: test_ResolucaoTest_AdicionarGrupo");
        }
    }

    /**
     * TODO: Finalizar o teste
     */
    public static void test_ResolucaoTest_AdicionarAtivade() {
        HibernateUtil.getSession().beginTransaction();               
        
        Atividade atividade = new Atividade("Atividade na resolução");
        HibernateUtil.getSession().save(atividade);
        
        Resolucao resolucao = new Resolucao("Resolução com atividade");
        resolucao.addAtividade(atividade, 2.5);
        
        HibernateUtil.getSession().save(resolucao);
        
        HibernateUtil.getSession().getTransaction().commit();

        if (resolucao.getAtividadeResolucaos().size() == 1) {
            for (AtividadeResolucao atr : resolucao.getAtividadeResolucaos()) {
                System.out.println(atr.toString());
            }
        } else {
            System.err.println("Erro: test_ResolucaoTest_AdicionarGrupo");
        }
    }
}

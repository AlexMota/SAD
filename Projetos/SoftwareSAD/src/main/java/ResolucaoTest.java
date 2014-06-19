
import br.ufg.es.sad.entity.Atividade;
import br.ufg.es.sad.entity.AtividadeResolucao;
import br.ufg.es.sad.entity.Grupo;
import br.ufg.es.sad.entity.Resolucao;
import br.ufg.es.sad.entity.Valor;
import br.ufg.es.sad.persistence.DAOFactory;
import br.ufg.es.sad.persistence.dao.ResolucaoDAO;
import java.util.Iterator;
import java.util.List;

public class ResolucaoTest {

    public static void main(String[] args) {
        test_ResolucaoTest_Criar();
        test_ResolucaoTest_Listar();
        test_ResolucaoTest_Excluir();
        test_ResolucaoTest_Listar();
        test_ResolucaoTest_AdicionarGrupo();
    }

    public static void test_ResolucaoTest_Criar() {
        System.err.println(" ************ Cria Resolução ************ ");
        Resolucao resolucao_1 = new Resolucao("Ano 1");
        Resolucao resolucao_2 = new Resolucao("Ano 2");
        Resolucao resolucao_3 = new Resolucao("Ano 3");

        DAOFactory factory = DAOFactory.getFactory();
        ResolucaoDAO resolucaoDAO = factory.getResolucaoDAO();
        resolucaoDAO.beginTransaction();

        resolucaoDAO.salvar(resolucao_1);
        resolucaoDAO.salvar(resolucao_2);
        resolucaoDAO.salvar(resolucao_3);

        resolucaoDAO.commitTransaction();
    }

    public static void test_ResolucaoTest_Excluir() {
        System.err.println(" ************ Excluir ************ ");
        DAOFactory factory = DAOFactory.getFactory();
        ResolucaoDAO resolucaoDAO = factory.getResolucaoDAO();
        resolucaoDAO.beginTransaction();

        boolean exluido = resolucaoDAO.excluirId(new Integer(1));
        System.err.println("Exluido: 1 -> " + exluido);

        resolucaoDAO.commitTransaction();
    }

    public static void test_ResolucaoTest_Listar() {
        System.err.println(" ************ Listar ************ ");
        DAOFactory factory = DAOFactory.getFactory();
        ResolucaoDAO resolucaoDAO = factory.getResolucaoDAO();

        List a = resolucaoDAO.listar();
        for (Iterator it = a.iterator(); it.hasNext();) {
            Resolucao resolucao = (Resolucao) it.next();
            System.err.println(resolucao.toString());
        }
    }

    public static void test_ResolucaoTest_AdicionarGrupo() {
        System.err.println(" ************ Adiciona Grupo na Resolução ************ ");
        DAOFactory factory = DAOFactory.getFactory();
        ResolucaoDAO resolucaoDAO = factory.getResolucaoDAO();
        resolucaoDAO.beginTransaction();
        
        Resolucao resolucao = new Resolucao("Ano com grupo");
        resolucao.addGrupo(new Grupo("ATIVIDADES DE ENSINO"));
        resolucao.addGrupo(new Grupo("PRODUÇÃO INTELECTUAL"));
        resolucao.addGrupo(new Grupo("ATIVIDADES DE PESQUISA E EXTENSÃO"));
        resolucao.addGrupo(new Grupo("ATIVIDADES ADMINISTRATIVAS E DE REPRESENTAÇÃO"));
        
        resolucaoDAO.salvar(resolucao);
        resolucaoDAO.commitTransaction();
        
        if(resolucao.getGrupos().size() == 4){
            for (Grupo grupo : resolucao.getGrupos()) {
                System.out.println(grupo.toString());
            }
        }
        else{
            System.err.println("Erro: test_ResolucaoTest_AdicionarGrupo");
        }
    }
    
    /**
     * TODO: Finalizar o teste
     */
    public static void test_ResolucaoTest_AdicionarAtivade() {
        System.err.println(" ************ Adiciona Atividade na Resolução ************ ");
        DAOFactory factory = DAOFactory.getFactory();
        ResolucaoDAO resolucaoDAO = factory.getResolucaoDAO();
        resolucaoDAO.beginTransaction();
        
        Resolucao resolucao = new Resolucao("Ano com atividade");
       //resolucao.addAtividadeResolucao(new AtividadeResolucao(resolucao, new Valor(2), new Atividade("")));
        
        resolucaoDAO.salvar(resolucao);
        resolucaoDAO.commitTransaction();
        
        if(resolucao.getGrupos().size() == 4){
            for (Grupo grupo : resolucao.getGrupos()) {
                System.out.println(grupo.toString());
            }
        }
        else{
            System.err.println("Erro: test_ResolucaoTest_AdicionarGrupo");
        }
    }
}

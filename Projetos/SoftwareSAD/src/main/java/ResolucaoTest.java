
import br.ufg.es.sad.entity.Resolucao;
import br.ufg.es.sad.persistence.DAOFactory;
import br.ufg.es.sad.persistence.dao.IResolucaoDAO;
import java.util.Iterator;
import java.util.List;

public class ResolucaoTest {

    public static void main(String[] args) {
        criar();
        listar();
        excluir();
        listar();
    }

    public static void criar() {
        System.err.println(" ************ Cria Resolução ************ ");
        Resolucao resolucao_1 = new Resolucao("Ano 1");
        Resolucao resolucao_2 = new Resolucao("Ano 2");
        Resolucao resolucao_3 = new Resolucao("Ano 3");

        DAOFactory factory = DAOFactory.getFactory();
        IResolucaoDAO resolucaoDAO = factory.getResolucaoDAO();
        resolucaoDAO.beginTransaction();

        resolucaoDAO.salvar(resolucao_1);
        resolucaoDAO.salvar(resolucao_2);
        resolucaoDAO.salvar(resolucao_3);

        resolucaoDAO.commitTransaction();
    }

    public static void excluir() {
        System.err.println(" ************ Excluir ************ ");
        DAOFactory factory = DAOFactory.getFactory();
        IResolucaoDAO resolucaoDAO = factory.getResolucaoDAO();
        resolucaoDAO.beginTransaction();
        
        boolean exluido = resolucaoDAO.excluirId(new Integer(1));
        System.err.println("Exluido: 1 -> " + exluido);

        resolucaoDAO.commitTransaction();
    }

    public static void listar() {
        System.err.println(" ************ Listar ************ ");
        DAOFactory factory = DAOFactory.getFactory();
        IResolucaoDAO resolucaoDAO = factory.getResolucaoDAO();

        List a = resolucaoDAO.listar();
        for (Iterator it = a.iterator(); it.hasNext();) {
            Resolucao resolucao = (Resolucao) it.next();
            System.err.println(resolucao.toString());
        }
    }
}

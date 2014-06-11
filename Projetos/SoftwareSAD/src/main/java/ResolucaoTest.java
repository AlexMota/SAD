
import br.ufg.es.sad.entity.Resolucao;
import br.ufg.es.sad.persistence.DAOFactory;
import br.ufg.es.sad.persistence.dao.IResolucaoDAO;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ResolucaoTest {

    public static void main(String[] args) {
        criar();
        listar();
    }

    public static void criar() {
        Resolucao resolucao = new Resolucao("Ano 2", toStartOfYear(2014));

        DAOFactory factory = DAOFactory.getFactory();
        IResolucaoDAO resolucaoDAO = factory.getResolucaoDAO();
        resolucaoDAO.beginTransaction();
        resolucaoDAO.salvar(resolucao);
        resolucaoDAO.commitTransaction();
    }
    
    public static void excluir(){
        
    }

    public static void listar() {
        DAOFactory factory = DAOFactory.getFactory();
        IResolucaoDAO resolucaoDAO = factory.getResolucaoDAO();

        List a = resolucaoDAO.listar();
        for (Iterator it = a.iterator(); it.hasNext();) {
            Resolucao resolucao = (Resolucao) it.next();
            System.err.println(resolucao.toString());
        }
    }

    public static Date toStartOfYear(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_YEAR, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
}

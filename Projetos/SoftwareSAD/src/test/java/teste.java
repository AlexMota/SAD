
import br.ufg.es.sad.entity.Resolucao;
import br.ufg.es.sad.persistence.HibernateUtil;
import java.util.Calendar;
import java.util.Date;
import junit.framework.TestCase;
import org.hibernate.classic.Session;

/**
 *
 * @author Phelipe
 */
public class teste extends TestCase {

    public void insert() {
//        Resolucao resolucao = new Resolucao("Ano  01", toStartOfYear(2014));
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        //Save the employee in database
//        session.save(resolucao);
//
//        //Commit the transaction
//        session.getTransaction().commit();
//        HibernateUtil.shutdown();
//
//        assertEquals(new Integer(1), resolucao.getId());
    }

    public Date toStartOfYear(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_YEAR, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
}

package test.br.ufg.es.sad.persistence;

import br.ufg.es.sad.entity.Departament;
import br.ufg.es.sad.persistence.util.HibernateUtil;
import junit.framework.TestCase;
import org.hibernate.Session;

/**
 *
 * @author Phelipe Alves de Souza
 */
public class DepartamentTest extends TestCase {
    
    public void insert() {
        Departament departament = new Departament();
        departament.setId(Integer.SIZE);
        departament.setName("Institudo de informatica");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        //Save the employee in database
        session.save(departament);

        //Commit the transaction
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }

}

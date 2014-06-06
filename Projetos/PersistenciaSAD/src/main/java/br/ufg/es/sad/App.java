package br.ufg.es.sad;

import br.ufg.es.sad.entity.Departament;
import br.ufg.es.sad.persistence.util.HibernateUtil;
import org.hibernate.Session;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Departament departament = new Departament();
        departament.setId(Integer.SIZE);
        departament.setName("Institudo de informatica");
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            //Save the employee in database
            session.save(departament);

            //Commit the transaction
            session.getTransaction().commit();

            HibernateUtil.shutdown();
        } catch (ExceptionInInitializerError e) {
            System.err.println(" -> " + e.getMessage());
        }

    }
}

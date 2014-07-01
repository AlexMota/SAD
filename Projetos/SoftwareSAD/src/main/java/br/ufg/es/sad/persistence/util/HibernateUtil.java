package br.ufg.es.sad.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * Classe utilitária para obtermos a sessão, iniciar a transação, commit, fechar
 * sessão e etc.
 *
 * @author Phelipe
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

    public static Session getSession() {

        Session session = threadLocal.get();

        if (session == null) {
            session = sessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }

    public static void beginTransaction() {
        getSession().beginTransaction();
    }

    public static void commitTransaction() {
        getSession().getTransaction().commit();
    }

    public static void rollBackTransaction() {
        getSession().getTransaction().rollback();
    }

    public static void closeSession() {
        getSession().close();
    }
}

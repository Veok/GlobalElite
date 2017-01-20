package hdao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author L on 18.01.2017.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();


    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

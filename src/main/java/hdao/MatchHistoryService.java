package hdao;

import domain.model.MatchHistory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author L on 20.01.2017.
 */
public class MatchHistoryService {


    public static List<MatchHistory> getListOfHistory() {
        List<MatchHistory> list = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            Session session1 = sessionFactory.openSession();
            session1.getTransaction();
            session1.getTransaction().begin();
            list = session1.createQuery("from MatchHistory").list();
            session1.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}

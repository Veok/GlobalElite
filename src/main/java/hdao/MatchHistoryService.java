package hdao;

import domain.model.MatchHistory;
import domain.model.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author L on 20.01.2017.
 */
public class MatchHistoryService {


    public List<MatchHistory> getListOfHistory() {
        List<MatchHistory> list = new ArrayList<MatchHistory>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = null;
        try {
            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            Session session1 = sessionFactory.openSession();
            session1.getTransaction();
            session1.getTransaction().begin();
            org.hibernate.query.Query query = session1.createQuery("from MatchHistory ");
            list = query.list();
            session1.getTransaction().commit();
            return list;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
       return list;
    }
}

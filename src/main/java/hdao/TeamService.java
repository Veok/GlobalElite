package hdao;

import domain.model.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author L on 20.01.2017.
 */
public class TeamService {

    public static Team getTeamByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = null;
        Team team = null;

        try {
            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            Session session1 = sessionFactory.openSession();
            session1.getTransaction();
            org.hibernate.query.Query query = session1.createQuery("from Team where name='" + name +"'");
            team = (Team) query.uniqueResult();
            session1.getTransaction().commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return team;
    }

    public List<Team> getListOfTeam() {
        List<Team> list = new ArrayList<Team>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = null;
        try {
            tx.begin();
            list = session.createQuery("from Team").list();
            tx.commit();
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

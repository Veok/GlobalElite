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

    public  Team getTeamByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Team team = null;

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session1 = sessionFactory.openSession();
            session1.getTransaction();
            org.hibernate.query.Query query = session1.createQuery("from Team where name='" + name + "'");
            team = (Team) query.uniqueResult();
            session1.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return team;
    }

    public  List<Team> getListOfTeam() {
        List<Team> list = new ArrayList<>();

        SessionFactory session = HibernateUtil.getSessionFactory();
        Session s = session.openSession();

        try {
            s.getTransaction();
            s.getTransaction().begin();
            list = s.createQuery("from Team ").list();
            s.getTransaction().commit();
        } catch (Exception e) {
            if (s.getTransaction() != null) {
                s.getTransaction().rollback();
            }
        } finally {
            s.close();
        }
        return list;
    }


}

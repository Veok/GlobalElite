package hdao.services;

import domain.model.Team;
import hdao.HibernateUtil;
import hdao.repositories.IHTeamRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author L on 20.01.2017.
 */
public class TeamService extends EntityService<Team> implements IHTeamRepository {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session = sessionFactory.openSession();

    public TeamService() {
    }

    @Override
    public void getById(int id) {
        try {
            session.getTransaction();
            session.getTransaction().begin();
            session.load(Team.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public List<Team> withCountry(String country) {
        List<Team> list = new ArrayList<>();
        try {
            session.getTransaction();
            session.getTransaction().begin();
            list = session.createQuery("from Team t where t.country=country").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return list;
    }


    @Override
    public Team withName(String name) {

        Team team = null;
        try {
            session.getTransaction();
            session.getTransaction().begin();
            org.hibernate.query.Query query = session.createQuery("from Team where name='" + name + "'");
            team = (Team) query.uniqueResult();
            session.getTransaction().commit();
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


}

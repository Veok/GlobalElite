package hdao.services;

import domain.model.MatchHistory;
import hdao.HibernateUtil;
import hdao.repositories.IHMatchHistoryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author L on 20.01.2017.
 */
public class MatchHistoryService extends EntityService<MatchHistory> implements IHMatchHistoryRepository {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session = sessionFactory.openSession();

    public MatchHistoryService() {
    }

    @Override
    public List<MatchHistory> bestTeam() {
        List list = new ArrayList<>();
        try {
            session.getTransaction();
            session.getTransaction().begin();
            list = session.createQuery("select max(MatchHistory .scoreOfTeam1)" +
                    " from MatchHistory scoreOfTeam1").list();
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
    public List<MatchHistory> worstTeam() {
        List list = new ArrayList<>();
        try {
            session.getTransaction();
            session.getTransaction().begin();
            list = session.createQuery("select min(MatchHistory .scoreOfTeam1)" +
                    " from MatchHistory scoreOfTeam1").list();
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
    public List<MatchHistory> onMap(String name) {
        List<MatchHistory> list = new ArrayList<>();
        try {
            session.getTransaction();
            session.getTransaction().begin();
            list = session.createQuery("from MatchHistory where gameMap='" + name + "'").list();
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
    public void getById(int id) {
        try {
            session.getTransaction();
            session.getTransaction().begin();
            session.load(MatchHistory.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }
}

package hdao.services;

import hdao.HibernateUtil;
import hdao.repositories.IHRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author L on 23.01.2017.
 */
public abstract class EntityService<TEntity> implements IHRepository<TEntity> {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session = sessionFactory.openSession();

    @Override
    public List<TEntity> getAll(String entityName) {
        List<TEntity> list = new ArrayList<>();

        try {
            session.getTransaction();
            session.getTransaction().begin();
            list = session.createQuery("from " + entityName + " ").list();
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
    public void update(TEntity entity) {
        try {
            session.getTransaction();
            session.getTransaction().begin();
            session.update(entity);
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
    public void add(TEntity entity) {
        try {
            session.getTransaction();
            session.getTransaction().begin();
            session.persist(entity);
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
    public void delete(TEntity entity) {
        try {
            session.getTransaction();
            session.getTransaction().begin();
            session.delete(entity);
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

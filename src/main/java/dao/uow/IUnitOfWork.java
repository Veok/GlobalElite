package dao.uow;

/**
 * @author L on 23.11.2016.
 */
public interface IUnitOfWork {

    void saveChanges();

    void rollback();

    void markAsNew(Entity entity);

    void markAsDeleted(Entity entity);

    void markAsChanged(Entity entity);
}

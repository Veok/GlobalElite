package dao.uow;

/**
 * @author L on 23.11.2016.
 */
public interface IUnitOfWork {

    public void saveChanges();

    public void rollback();

    public void markAsNew(Entity entity);

    public void markAsDeleted(Entity entity);

    public void markAsChanged(Entity entity);
}

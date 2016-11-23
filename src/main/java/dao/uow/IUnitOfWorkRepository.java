package dao.uow;

/**
 * @author L on 23.11.2016.
 */
public interface IUnitOfWorkRepository {

    public void persistAdd(Entity entity);

    public void persistDelete(Entity entity);

    public void persistUpdate(Entity entity);
}

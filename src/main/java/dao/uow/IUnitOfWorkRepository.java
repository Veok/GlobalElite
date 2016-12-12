package dao.uow;

/**
 * @author L on 23.11.2016.
 */
public interface IUnitOfWorkRepository {

    void persistAdd(Entity entity);

    void persistDelete(Entity entity);

    void persistUpdate(Entity entity);
}

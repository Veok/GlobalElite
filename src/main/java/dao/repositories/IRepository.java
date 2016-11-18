package dao.repositories;

import domain.model.IHaveId;

import java.util.List;

/**
 * @author L on 17.11.2016.
 */
public interface IRepository<TEntity extends IHaveId> {

    public List<TEntity> getAll();

    public TEntity get(int personId);

    public void update(TEntity entity);

    public void add(TEntity entity);

    public void delete(TEntity entity);

}

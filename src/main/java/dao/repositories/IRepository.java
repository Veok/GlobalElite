package dao.repositories;

import domain.model.IHaveId;

import java.util.List;

/**
 * @author L on 17.11.2016.
 */
public interface IRepository<TEntity extends IHaveId> {

    List<TEntity> getAll();

    TEntity get(int playerId);

    TEntity getName(String name);

    void update(TEntity entity);

    void add(TEntity entity);

    void delete(TEntity entity);

    void getLastIdForForeignKey();


}

package hdao.repositories;

import java.util.List;

/**
 * @author L on 23.01.2017.
 */
public interface IHRepository<TEntity> {

    List<TEntity> getAll(String entityName);

    void update(TEntity entity);

    void add(TEntity entity);

    void delete(TEntity entity);
}

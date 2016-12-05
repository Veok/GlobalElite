package dao.repositories;

import domain.model.GameMap;

import java.util.List;

/**
 * @author L on 05.12.2016.
 */
public interface IGameMapRepository extends IRepository<GameMap> {

    List<GameMap> maps(String gameMap);

}

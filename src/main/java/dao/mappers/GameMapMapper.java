package dao.mappers;

import domain.model.GameMap;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author L on 05.12.2016.
 */
public class GameMapMapper implements IMapResultSetIntoEntity {

    public GameMap map(ResultSet rs) throws SQLException {
        GameMap gameMap = new GameMap();
        gameMap.setId(rs.getInt("id"));
        gameMap.setNameOfMap(rs.getString("name"));
        return gameMap;
    }

}

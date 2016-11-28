package dao.mappers;

import domain.model.PlayerStatistics;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author L on 17.11.2016.
 */
public class PlayerStatisticsMapper implements IMapResultSetIntoEntity {

    public PlayerStatistics map(ResultSet rs) throws SQLException {
        PlayerStatistics playerStatistics = new PlayerStatistics();
        playerStatistics.setId(rs.getInt("id"));
        playerStatistics.setKills(rs.getInt("kills"));
        playerStatistics.setDeaths(rs.getInt("deaths"));
        return playerStatistics;
    }
}

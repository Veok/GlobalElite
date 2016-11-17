package dao.mappers;

import domain.model.TeamStats;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author L on 17.11.2016.
 */
public class TeamStatsMapper implements IMapResultSetIntoEntity {

    public TeamStats map(ResultSet rs) throws SQLException {
        TeamStats teamStats = new TeamStats();
        teamStats.setId(rs.getInt("id"));
        teamStats.setWins(rs.getInt("wins"));
        teamStats.setLooses(rs.getInt("looses"));
        teamStats.setDraws(rs.getInt("draws"));
        return teamStats;
    }
}

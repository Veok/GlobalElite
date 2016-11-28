package dao.mappers;

import domain.model.TeamStatistics;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author L on 17.11.2016.
 */
public class TeamStatisticsMapper implements IMapResultSetIntoEntity {

    public TeamStatistics map(ResultSet rs) throws SQLException {
        TeamStatistics teamStatistics = new TeamStatistics();
        teamStatistics.setId(rs.getInt("id"));
        teamStatistics.setWins(rs.getInt("wins"));
        teamStatistics.setLooses(rs.getInt("looses"));
        teamStatistics.setDraws(rs.getInt("draws"));
        return teamStatistics;
    }
}

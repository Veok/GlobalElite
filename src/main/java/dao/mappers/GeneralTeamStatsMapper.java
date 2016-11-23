package dao.mappers;

import domain.model.GeneralTeamStats;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author L on 17.11.2016.
 */
public class GeneralTeamStatsMapper implements IMapResultSetIntoEntity {

    public GeneralTeamStats map(ResultSet rs) throws SQLException {
        GeneralTeamStats generalTeamStats = new GeneralTeamStats();
        generalTeamStats.setId(rs.getInt("id"));
        generalTeamStats.setWins(rs.getInt("wins"));
        generalTeamStats.setLooses(rs.getInt("looses"));
        generalTeamStats.setDraws(rs.getInt("draws"));
        return generalTeamStats;
    }
}

package dao.mappers;

import domain.model.MatchHistory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author L on 17.11.2016.
 */
public class MatchHistoryMapper implements IMapResultSetIntoEntity {
    public MatchHistory map(ResultSet rs) throws SQLException {
        MatchHistory matchHistory = new MatchHistory();
        matchHistory.setId(rs.getInt("id"));
        matchHistory.setScoreOfTeam1(rs.getInt("scoreOfTeam1"));
        matchHistory.setScoreOfTeam2(rs.getInt("scoreOfTeam2"));
        matchHistory.setTimeOfMatch(rs.getDate("timeOfMatch"));

        return matchHistory;
    }
}

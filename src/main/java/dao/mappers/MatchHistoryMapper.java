package dao.mappers;

import domain.model.MatchHistory;
import domain.model.MatchScoreBoard;
import domain.model.Team;

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
        matchHistory.setTeam1((Team) rs.getObject("TEAM_1_ID"));
        matchHistory.setTeam2((Team) rs.getObject("TEAM_2_ID"));
        matchHistory.setMapId(rs.getInt("MAP_ID"));
        matchHistory.setMatchScoreBoard((MatchScoreBoard) rs.getObject("SCOREBOARD_ID"));
        return matchHistory;
    }
}

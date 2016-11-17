package dao.mappers;

import domain.model.HistoryOfMatch;
import domain.model.ScoreBoard;
import domain.model.Team;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author L on 17.11.2016.
 */
public class HistoryOfMatchMapper implements IMapResultSetIntoEntity {
    public HistoryOfMatch map(ResultSet rs) throws SQLException {
        HistoryOfMatch historyOfMatch = new HistoryOfMatch();
        historyOfMatch.setId(rs.getInt("id"));
        historyOfMatch.setScoreOfTeam1(rs.getInt("scoreOfTeam1"));
        historyOfMatch.setScoreOfTeam2(rs.getInt("scoreOfTeam2"));
        historyOfMatch.setTimeOfMatch(rs.getDate("timeOfMatch"));
        historyOfMatch.setTeam1((Team) rs.getObject("TEAM_1_ID"));
        historyOfMatch.setTeam2((Team) rs.getObject("TEAM_2_ID"));
        historyOfMatch.setMapId(rs.getInt("MAP_ID"));
        historyOfMatch.setScoreBoard((ScoreBoard) rs.getObject("SCOREBOARD_ID"));
        return historyOfMatch;
    }
}

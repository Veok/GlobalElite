package dao.mappers;

import domain.model.MatchScoreBoard;
import domain.model.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author L on 17.11.2016.
 */
public class MatchScoreBoardMapper implements IMapResultSetIntoEntity {

    public MatchScoreBoard map(ResultSet rs) throws SQLException {
        MatchScoreBoard matchScoreBoard = new MatchScoreBoard();
        matchScoreBoard.setId(rs.getInt("id"));
        matchScoreBoard.setKillsInMatch(rs.getInt("killsInMatch"));
        matchScoreBoard.setDeathsInMatch(rs.getInt("deathsInMatch"));
        matchScoreBoard.setPlayer((Player) rs.getObject("PLAYER_ID"));
        return matchScoreBoard;
    }
}

package dao.mappers;

import domain.model.Player;
import domain.model.ScoreBoard;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author L on 17.11.2016.
 */
public class ScoreBoardMapper implements IMapResultSetIntoEntity {

    public ScoreBoard map(ResultSet rs) throws SQLException {
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.setId(rs.getInt("id"));
        scoreBoard.setKillsInMatch(rs.getInt("killsInMatch"));
        scoreBoard.setDeathsInMatch(rs.getInt("deathsInMatch"));
        scoreBoard.setPlayer((Player) rs.getObject("PLAYER_ID"));
        return scoreBoard;
    }
}

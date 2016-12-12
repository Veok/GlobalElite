package dao.mappers;

import domain.model.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author L on 17.11.2016.
 */
public class PlayerRepositoryMapper implements IMapResultSetIntoEntity {

    public Player map(ResultSet rs) throws SQLException {

        Player player = new Player();
        player.setId(rs.getInt("id"));
        player.setNick(rs.getString("nick"));
        player.setDateOfBirth(rs.getDate("DoB"));
        player.setCountry(rs.getString("country"));
        player.setSteamId(rs.getString("steamId"));
        return player;
    }
}

package dao.mappers;

        import domain.model.PlayerStats;

        import java.sql.ResultSet;
        import java.sql.SQLException;

/**
 * @author L on 17.11.2016.
 */
public class PlayerStatsMapper implements IMapResultSetIntoEntity {

    public PlayerStats map(ResultSet rs) throws SQLException {
        PlayerStats playerStats = new PlayerStats();
        playerStats.setId(rs.getInt("id"));
        playerStats.setKills(rs.getInt("kills"));
        playerStats.setDeaths(rs.getInt("deaths"));
        playerStats.setRatio(rs.getDouble("ratio"));
        return playerStats;
    }
}

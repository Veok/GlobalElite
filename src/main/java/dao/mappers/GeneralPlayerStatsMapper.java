package dao.mappers;

        import domain.model.GeneralPlayerStats;

        import java.sql.ResultSet;
        import java.sql.SQLException;

/**
 * @author L on 17.11.2016.
 */
public class GeneralPlayerStatsMapper implements IMapResultSetIntoEntity {

    public GeneralPlayerStats map(ResultSet rs) throws SQLException {
        GeneralPlayerStats generalPlayerStats = new GeneralPlayerStats();
        generalPlayerStats.setId(rs.getInt("id"));
        generalPlayerStats.setKills(rs.getInt("kills"));
        generalPlayerStats.setDeaths(rs.getInt("deaths"));
        generalPlayerStats.setRatio(rs.getDouble("ratio"));
        return generalPlayerStats;
    }
}

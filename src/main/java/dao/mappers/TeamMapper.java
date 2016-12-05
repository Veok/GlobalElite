package dao.mappers;

import domain.model.Team;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author L on 17.11.2016.
 */
public class TeamMapper implements IMapResultSetIntoEntity {

    public Team map(ResultSet rs) throws SQLException {
        Team team = new Team();
        team.setId(rs.getInt("id"));
        team.setName(rs.getString("name"));
        team.setCountry(rs.getString("country"));
        return team;
    }
}

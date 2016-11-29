package dao.mappers;

import domain.model.Team;
import domain.model.TeamStatistics;

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
        team.setTeamStatistics((TeamStatistics) rs.getObject("TEAM_STATS_ID"));
        return team;
    }
}

package dao.mappers;

import domain.model.Player;
import domain.model.Team;
import domain.model.TeamStats;

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
        team.setPlayers((Player) rs.getObject("PLAYERS_ID"));
        team.setTeamStats((TeamStats) rs.getObject("TEAM_STATS_ID"));
        return team;
    }
}

package dao;

import dao.mappers.IMapResultSetIntoEntity;
import domain.model.Team;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author L on 13.11.2016.
 */
public class TeamRepository extends RepositoryBase<Team> {


    public TeamRepository(Connection connection, IMapResultSetIntoEntity<Team> mapper) {
        super(connection, mapper);
    }

    protected String insertSql() {
        return "INSERT INTO TEAM(name, country, TEAM_STATS_ID, PLAYERS_ID) values (?, ?, ?, ?)";
    }

    protected String updateSql() {
        return "UPDATE TEAM SET (name, country, TEAM_STATS_ID, PLAYERS_ID) = (?,?,?,?) where id=?";
    }

    protected void setUpdate(Team team) throws SQLException {
        update.setString(1, team.getName());
        update.setString(2, team.getCountry());
        update.setInt(3, team.getTeamStats().getId());
        update.setInt(4, team.getPlayers().getId());
    }

    protected void setInsert(Team team) throws SQLException {
        insert.setString(1, team.getName());
        insert.setString(2, team.getCountry());
        insert.setInt(3, team.getTeamStats().getId());
        insert.setInt(4, team.getPlayers().getId());
    }

    @Override
    protected String createTableSql() {
        return "" + "CREATE TABLE TEAM("
                + "id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,"
                + "name varchar(25),"
                + "country varchar(25),"
                + "TEAM_STATS_ID int,"
                + "PLAYERS_ID int,"
                + "FOREIGN KEY (TEAM_STATS_ID) REFERENCES TEAM_STATS(id),"
                + "FOREIGN KEY (PLAYERS_ID) REFERENCES PLAYER(id)" + ")";
    }

    @Override
    protected String tableName() {
        return "TEAM";
    }
}
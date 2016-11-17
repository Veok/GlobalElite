package dao;

import dao.mappers.IMapResultSetIntoEntity;
import domain.model.TeamStats;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author L on 13.11.2016.
 */
public class TeamStatsRepository extends RepositoryBase<TeamStats> {

    public TeamStatsRepository(Connection connection, IMapResultSetIntoEntity<TeamStats> mapper) {
        super(connection, mapper);
    }


    protected String insertSql() {
        return "INSERT INTO TEAM_STATS(wins, looses, draws, points) values (?, ?, ?, ?)";
    }

    protected String updateSql() {
        return "UPDATE TEAM_STATS SET (wins,looses,draws,points) = (?,?,?,?) where id=?";
    }

    protected void setUpdate(TeamStats teamStats) throws SQLException {
        update.setInt(1, teamStats.getWins());
        update.setInt(2, teamStats.getLooses());
        update.setInt(3, teamStats.getDraws());
        update.setDouble(4, teamStats.getPoints());
    }

    protected void setInsert(TeamStats teamStats) throws SQLException {
        insert.setInt(1, teamStats.getWins());
        insert.setInt(2, teamStats.getLooses());
        insert.setInt(3, teamStats.getDraws());
        insert.setDouble(4, teamStats.getPoints());
    }

    @Override
    protected String createTableSql() {
        return "" + "CREATE TABLE TEAM_STATS("
                + "id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,"
                + "wins int,"
                + "looses int,"
                + "draws int,"
                + "points double" + ")";
    }

    @Override
    protected String tableName() {
        return "TEAM_STATS";
    }
}
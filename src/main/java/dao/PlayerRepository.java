package dao;

import java.sql.Connection;

/**
 * Created by L on 13.11.2016.
 */
public class PlayerRepository extends RepositoryBase {

    public PlayerRepository(Connection connection) {
        super(connection);
    }


    @Override
    protected String createTableSql() {
        return "" + "CREATE TABLE PLAYER("
                + "id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,"
                + "nick varchar(25),"
                + "DoB DATE,"
                + "country varchar(25),"
                + "steamId varchar(25),"
                + "PLAYER_STATS_ID int,"
                + "FOREIGN KEY (PLAYER_STATS_ID) REFERENCES PLAYERSTATS(id)" + ")";
    }

    @Override
    protected String tableName() {
        return "PLAYER";
    }
}

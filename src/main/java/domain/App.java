package domain;

import dao.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            Connection connection =
                    DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
            TeamStatsRepository teamStatsRepository = new TeamStatsRepository(connection);
            PlayerStatsRepository playerStatsRepository = new PlayerStatsRepository(connection);
            PlayerRepository playerRepository = new PlayerRepository(connection);
            MapsRepository mapsRepository = new MapsRepository(connection);
            TeamRepository teamRepository = new TeamRepository(connection);
            ScoreBoardRepository scoreBoardRepository = new ScoreBoardRepository(connection);
            HistoryOfMatchRepository historyOfMatchRepository = new HistoryOfMatchRepository(connection);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

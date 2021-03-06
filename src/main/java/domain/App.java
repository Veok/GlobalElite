package domain;

import com.neovisionaries.i18n.CountryCode;
import dao.RepositoryCatalog;
import dao.repositories.IRepositoryCatalog;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;
import domain.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class App {
    public static void main(String[] args) {


        Player player = new Player();
        Team team = new Team();
        MatchHistory matchHistory = new MatchHistory();
        TeamStatistics teamStatistics = new TeamStatistics();
        TeamStatistics teamStatistics2 = new TeamStatistics();
        Team team2 = new Team();
        EnumDictionary enumDictionary = new EnumDictionary();
        GameMap map = new GameMap();

        player.setNick("Veok");
        player.setCountry(CountryCode.PL.getName());
        player.setTeam(team2);



        team.setName("Lelele");
        team.setCountry(CountryCode.PL.getName());
        team.setTeamStatistics(teamStatistics);
        team2.setTeamStatistics(teamStatistics2);



        matchHistory.setScoreOfTeam1(43);
        matchHistory.setScoreOfTeam2(44);
        matchHistory.setTeam1(team);
        matchHistory.setTeam2(team2);
        matchHistory.score();

        teamStatistics.setWins(10);
        teamStatistics.setDraws(2);
        teamStatistics.setLooses(2);
        player.getTeam().setId(1);

        map.setNameOfMap("DUST");
        matchHistory.setGameMap(map);

        String url = "jdbc:hsqldb:hsql://localhost/workdb";

        try {
            Connection connection = DriverManager.getConnection(url);
            IUnitOfWork uow = new UnitOfWork(connection);
            IRepositoryCatalog catalog2 = new RepositoryCatalog(url);


            catalog2.teamsStats().add(teamStatistics);

            catalog2.teams().add(team);


            catalog2.teamsStats().add(teamStatistics2);
            catalog2.teams().add(team2);


            catalog2.players().add(player);


            catalog2.maps().add(map);

            catalog2.dictionaries().add(enumDictionary);



            catalog2.history().add(matchHistory);

            catalog2.save();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

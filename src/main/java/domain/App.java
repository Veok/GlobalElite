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


        GeneralPlayerStats generalPlayerStats = new GeneralPlayerStats();
        Player player = new Player();
        Team team = new Team();
        MatchScoreBoard matchScoreBoard = new MatchScoreBoard();
        MatchHistory matchHistory = new MatchHistory();
        GeneralTeamStats generalTeamStats = new GeneralTeamStats();


        player.setNick("Veok");
        player.setCountry(CountryCode.PL.getName());
        player.setGeneralPlayerStats(generalPlayerStats);


        generalPlayerStats.setDeaths(20);
        generalPlayerStats.getRatio();

        team.setName("Lelele");
        team.setCountry(CountryCode.PL.getName());
        team.setPlayers(player);
        team.setGeneralTeamStats(generalTeamStats);

        matchScoreBoard.setPlayer(player);
        matchScoreBoard.setKillsInMatch(4);
        matchScoreBoard.setDeathsInMatch(2);

        matchHistory.setMapId(2);
        matchHistory.setMatchScoreBoard(matchScoreBoard);
        matchHistory.setScoreOfTeam1(43);
        matchHistory.setScoreOfTeam2(44);
        matchHistory.setTeam1(team);

        generalTeamStats.setWins(10);
        generalTeamStats.setDraws(2);
        generalTeamStats.setLooses(2);

        GeneralTeamStats generalTeamStats2 = new GeneralTeamStats();
        Team team2 = new Team();
        team2.setGeneralTeamStats(generalTeamStats2);
        team2.setPlayers(player);
        matchHistory.setTeam2(team2);

        EnumDictionary enumDictionary = new EnumDictionary();


        String url = "jdbc:hsqldb:hsql://localhost/workdb";

        try {
            Connection connection = DriverManager.getConnection(url);
            IUnitOfWork uow = new UnitOfWork(connection);
            IRepositoryCatalog catalog2 = new RepositoryCatalog(connection, uow);
            catalog2.playersStats().add(generalPlayerStats);
            catalog2.players().add(player);
            catalog2.dictionaries().add(enumDictionary);
            catalog2.teamsStats().add(generalTeamStats);
            catalog2.teams().add(team);
            catalog2.teams().add(team2);
            catalog2.scoreboards().add(matchScoreBoard);
            catalog2.history().add(matchHistory);
            catalog2.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

package domain;

import com.neovisionaries.i18n.CountryCode;
import domain.model.*;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author L on 11.11.2016.
 */

public class ModelTest {


    @Test
    public void testPlayerRatio() {
        Player player = new Player();
        GeneralPlayerStats generalPlayerStats = new GeneralPlayerStats();
        player.setGeneralPlayerStats(generalPlayerStats);
        player.getGeneralPlayerStats().setKills(10);
        player.getGeneralPlayerStats().setDeaths(20);
        assertEquals(0.5, player.getGeneralPlayerStats().getRatio(), 0.001);
    }

    @Test
    public void testTeamPoints() {
        GeneralTeamStats generalTeamStats = new GeneralTeamStats();
        generalTeamStats.setWins(3);
        generalTeamStats.setDraws(2);
        assertEquals(4, generalTeamStats.getPoints(), 0.001);
    }

    @Test
    public void testSteamId() {
        Player player = new Player();
        player.setSteamId("STEAM_0:1:38401525");
        assertEquals(true, player.validateSteamId());
    }

    @Test
    public void testPlayerCountry() {
        Player player = new Player();
        player.setCountry(CountryCode.PL.getName());
        assertEquals(CountryCode.PL.getName(), player.getCountry());
    }

    @Test
    public void testTeamCountry() {
        Team team = new Team();
        team.setCountry(CountryCode.US.getName());
        assertEquals(CountryCode.US.getName(), team.getCountry());
    }

    @Test
    public void testScoreBoardKillsInMatch() {

        MatchHistory matchHistory = new MatchHistory();
        Player player = new Player();
        GeneralPlayerStats generalPlayerStats = new GeneralPlayerStats();
        MatchScoreBoard matchScoreBoard = new MatchScoreBoard();

        player.setGeneralPlayerStats(generalPlayerStats);
        matchScoreBoard.setPlayer(player);
        matchHistory.setMatchScoreBoard(matchScoreBoard);

        matchScoreBoard.setKillsInMatch(10);
        matchScoreBoard.setPlayerStats();

        assertEquals(10, matchHistory.getMatchScoreBoard().getKillsInMatch());

    }

    @Test
    public void testPlayerKillsInScoreBoard() {

        MatchHistory matchHistory = new MatchHistory();
        Player player = new Player();
        GeneralPlayerStats generalPlayerStats = new GeneralPlayerStats();
        MatchScoreBoard matchScoreBoard = new MatchScoreBoard();

        player.setGeneralPlayerStats(generalPlayerStats);
        matchScoreBoard.setPlayer(player);
        matchHistory.setMatchScoreBoard(matchScoreBoard);

        matchScoreBoard.setKillsInMatch(10);
        matchScoreBoard.setPlayerStats();

        assertEquals(10, matchHistory.getMatchScoreBoard().getPlayer().getGeneralPlayerStats().getKills());

    }

    @Test
    public void testScoreBoardDeathsInMatch() {
        MatchHistory matchHistory = new MatchHistory();
        Player player = new Player();
        GeneralPlayerStats generalPlayerStats = new GeneralPlayerStats();
        MatchScoreBoard matchScoreBoard = new MatchScoreBoard();

        player.setGeneralPlayerStats(generalPlayerStats);
        matchScoreBoard.setPlayer(player);
        matchHistory.setMatchScoreBoard(matchScoreBoard);

        matchScoreBoard.setDeathsInMatch(20);
        matchScoreBoard.setPlayerStats();

        assertEquals(20, matchHistory.getMatchScoreBoard().getDeathsInMatch());

    }

    @Test
    public void testPlayerDeathsInScoreBoard() {
        MatchHistory matchHistory = new MatchHistory();
        Player player = new Player();
        GeneralPlayerStats generalPlayerStats = new GeneralPlayerStats();
        MatchScoreBoard matchScoreBoard = new MatchScoreBoard();

        player.setGeneralPlayerStats(generalPlayerStats);
        matchScoreBoard.setPlayer(player);
        matchHistory.setMatchScoreBoard(matchScoreBoard);

        matchScoreBoard.setDeathsInMatch(20);
        matchScoreBoard.setPlayerStats();

        assertEquals(20, matchHistory.getMatchScoreBoard().getPlayer().getGeneralPlayerStats().getDeaths());

    }

    @Test
    public void testPlayerRatioAfterMatch() {
        MatchHistory matchHistory = new MatchHistory();
        Player player = new Player();
        GeneralPlayerStats generalPlayerStats = new GeneralPlayerStats();
        MatchScoreBoard matchScoreBoard = new MatchScoreBoard();

        player.setGeneralPlayerStats(generalPlayerStats);
        matchScoreBoard.setPlayer(player);
        matchHistory.setMatchScoreBoard(matchScoreBoard);

        generalPlayerStats.setKills(5);
        generalPlayerStats.setDeaths(15);
        matchScoreBoard.setKillsInMatch(10);
        matchScoreBoard.setDeathsInMatch(15);
        matchScoreBoard.setPlayerStats();

        assertEquals(0.5, player.getGeneralPlayerStats().getRatio(), 0.001);
    }

    @Test
    public void testTeam1Win() {

        MatchHistory matchHistory = new MatchHistory();
        Team team1 = new Team();
        Team team2 = new Team();
        GeneralTeamStats team1Stats = new GeneralTeamStats();
        GeneralTeamStats team2Stats = new GeneralTeamStats();

        team1.setGeneralTeamStats(team1Stats);
        team2.setGeneralTeamStats(team2Stats);

        matchHistory.setTeam1(team1);
        matchHistory.setTeam2(team2);

        matchHistory.setScoreOfTeam1(43);
        matchHistory.setScoreOfTeam2(20);

        matchHistory.score();

        assertEquals(1, team1.getGeneralTeamStats().getWins());

    }

    @Test
    public void testTeam2Looses() {
        MatchHistory matchHistory = new MatchHistory();
        Team team1 = new Team();
        Team team2 = new Team();
        GeneralTeamStats team1Stats = new GeneralTeamStats();
        GeneralTeamStats team2Stats = new GeneralTeamStats();

        team1.setGeneralTeamStats(team1Stats);
        team2.setGeneralTeamStats(team2Stats);

        matchHistory.setTeam1(team1);
        matchHistory.setTeam2(team2);

        matchHistory.setScoreOfTeam1(43);
        matchHistory.setScoreOfTeam2(20);

        matchHistory.score();
        assertEquals(1, team2.getGeneralTeamStats().getLooses());

    }

    @Test
    public void testTeam2Win() {

        MatchHistory matchHistory = new MatchHistory();
        Team team1 = new Team();
        Team team2 = new Team();
        GeneralTeamStats team1Stats = new GeneralTeamStats();
        GeneralTeamStats team2Stats = new GeneralTeamStats();

        team1.setGeneralTeamStats(team1Stats);
        team2.setGeneralTeamStats(team2Stats);

        matchHistory.setTeam1(team1);
        matchHistory.setTeam2(team2);

        matchHistory.setScoreOfTeam1(23);
        matchHistory.setScoreOfTeam2(30);

        matchHistory.score();

        assertEquals(1, team2.getGeneralTeamStats().getWins());
    }

    @Test
    public void testTeam1Looses() {
        MatchHistory matchHistory = new MatchHistory();
        Team team1 = new Team();
        Team team2 = new Team();
        GeneralTeamStats team1Stats = new GeneralTeamStats();
        GeneralTeamStats team2Stats = new GeneralTeamStats();

        team1.setGeneralTeamStats(team1Stats);
        team2.setGeneralTeamStats(team2Stats);

        matchHistory.setTeam1(team1);
        matchHistory.setTeam2(team2);

        matchHistory.setScoreOfTeam1(23);
        matchHistory.setScoreOfTeam2(30);

        matchHistory.score();
        assertEquals(1, team1.getGeneralTeamStats().getLooses());

    }

    @Test
    public void testDraw() {
        MatchHistory matchHistory = new MatchHistory();
        Team team1 = new Team();
        Team team2 = new Team();
        GeneralTeamStats team1Stats = new GeneralTeamStats();
        GeneralTeamStats team2Stats = new GeneralTeamStats();

        team1.setGeneralTeamStats(team1Stats);
        team2.setGeneralTeamStats(team2Stats);

        matchHistory.setTeam1(team1);
        matchHistory.setTeam2(team2);

        matchHistory.setScoreOfTeam1(50);
        matchHistory.setScoreOfTeam2(50);

        matchHistory.score();

        assertEquals(1, team1.getGeneralTeamStats().getDraws());
        assertEquals(1, team2.getGeneralTeamStats().getDraws());
    }

    @Test
    public void testSummaryOfTeamStatistics() {

        MatchHistory matchHistory = new MatchHistory();
        Team team1 = new Team();
        Team team2 = new Team();
        GeneralTeamStats team1Stats = new GeneralTeamStats();
        GeneralTeamStats team2Stats = new GeneralTeamStats();

        team1.setGeneralTeamStats(team1Stats);
        team2.setGeneralTeamStats(team2Stats);

        matchHistory.setTeam1(team1);
        matchHistory.setTeam2(team2);

        team1.getGeneralTeamStats().setWins(10);
        team1.getGeneralTeamStats().setLooses(20);
        team1.getGeneralTeamStats().setDraws(5);

        team2.getGeneralTeamStats().setWins(7);
        team2.getGeneralTeamStats().setLooses(9);
        team2.getGeneralTeamStats().setDraws(1);

        matchHistory.setScoreOfTeam1(90);
        matchHistory.setScoreOfTeam2(10);

        matchHistory.score();

        assertEquals(11, team1.getGeneralTeamStats().getWins());
        assertEquals(10, team2.getGeneralTeamStats().getLooses());
        assertEquals(13.5, team1.getGeneralTeamStats().getPoints(), 0.0001);
        assertEquals(7.5, team2.getGeneralTeamStats().getPoints(), 0.0001);
    }
}

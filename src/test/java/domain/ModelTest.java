package domain;

import com.neovisionaries.i18n.CountryCode;
import domain.model.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author L on 11.11.2016.
 */

public class ModelTest {


    @Test
    public void testPlayerRatio() {
        Player player = new Player();
        PlayerStatistics playerStatistics = new PlayerStatistics();
        player.setPlayerStatistics(playerStatistics);
        player.getPlayerStatistics().setKills(10);
        player.getPlayerStatistics().setDeaths(20);
        assertEquals(0.5, player.getPlayerStatistics().getRatio(), 0.001);
    }

    @Test
    public void testTeamPoints() {
        TeamStatistics teamStatistics = new TeamStatistics();
        teamStatistics.setWins(3);
        teamStatistics.setDraws(2);
        assertEquals(4, teamStatistics.getPoints(), 0.001);
    }

    @Test
    public void testSteamId() {
        Player player = new Player();
        player.setSteamId("STEAM_0:1:38401525");
        assertEquals("STEAM_0:1:38401525", player.getSteamId());
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
        PlayerStatistics playerStatistics = new PlayerStatistics();
        MatchScoreBoard matchScoreBoard = new MatchScoreBoard();

        player.setPlayerStatistics(playerStatistics);
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
        PlayerStatistics playerStatistics = new PlayerStatistics();
        MatchScoreBoard matchScoreBoard = new MatchScoreBoard();

        player.setPlayerStatistics(playerStatistics);
        matchScoreBoard.setPlayer(player);
        matchHistory.setMatchScoreBoard(matchScoreBoard);

        matchScoreBoard.setKillsInMatch(10);
        matchScoreBoard.setPlayerStats();

        assertEquals(10, matchHistory.getMatchScoreBoard().getPlayer().getPlayerStatistics().getKills());

    }

    @Test
    public void testScoreBoardDeathsInMatch() {
        MatchHistory matchHistory = new MatchHistory();
        Player player = new Player();
        PlayerStatistics playerStatistics = new PlayerStatistics();
        MatchScoreBoard matchScoreBoard = new MatchScoreBoard();

        player.setPlayerStatistics(playerStatistics);
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
        PlayerStatistics playerStatistics = new PlayerStatistics();
        MatchScoreBoard matchScoreBoard = new MatchScoreBoard();

        player.setPlayerStatistics(playerStatistics);
        matchScoreBoard.setPlayer(player);
        matchHistory.setMatchScoreBoard(matchScoreBoard);

        matchScoreBoard.setDeathsInMatch(20);
        matchScoreBoard.setPlayerStats();

        assertEquals(20, matchHistory.getMatchScoreBoard().getPlayer().getPlayerStatistics().getDeaths());

    }

    @Test
    public void testPlayerRatioAfterMatch() {
        MatchHistory matchHistory = new MatchHistory();
        Player player = new Player();
        PlayerStatistics playerStatistics = new PlayerStatistics();
        MatchScoreBoard matchScoreBoard = new MatchScoreBoard();

        player.setPlayerStatistics(playerStatistics);
        matchScoreBoard.setPlayer(player);
        matchHistory.setMatchScoreBoard(matchScoreBoard);

        playerStatistics.setKills(5);
        playerStatistics.setDeaths(15);
        matchScoreBoard.setKillsInMatch(10);
        matchScoreBoard.setDeathsInMatch(15);
        matchScoreBoard.setPlayerStats();

        assertEquals(0.5, player.getPlayerStatistics().getRatio(), 0.001);
    }

    @Test
    public void testTeam1Win() {

        MatchHistory matchHistory = new MatchHistory();
        Team team1 = new Team();
        Team team2 = new Team();
        TeamStatistics team1Stats = new TeamStatistics();
        TeamStatistics team2Stats = new TeamStatistics();

        team1.setTeamStatistics(team1Stats);
        team2.setTeamStatistics(team2Stats);

        matchHistory.setTeam1(team1);
        matchHistory.setTeam2(team2);

        matchHistory.setScoreOfTeam1(43);
        matchHistory.setScoreOfTeam2(20);

        matchHistory.score();

        assertEquals(1, team1.getTeamStatistics().getWins());

    }

    @Test
    public void testTeam2Looses() {
        MatchHistory matchHistory = new MatchHistory();
        Team team1 = new Team();
        Team team2 = new Team();
        TeamStatistics team1Stats = new TeamStatistics();
        TeamStatistics team2Stats = new TeamStatistics();

        team1.setTeamStatistics(team1Stats);
        team2.setTeamStatistics(team2Stats);

        matchHistory.setTeam1(team1);
        matchHistory.setTeam2(team2);

        matchHistory.setScoreOfTeam1(43);
        matchHistory.setScoreOfTeam2(20);

        matchHistory.score();
        assertEquals(1, team2.getTeamStatistics().getLooses());

    }

    @Test
    public void testTeam2Win() {

        MatchHistory matchHistory = new MatchHistory();
        Team team1 = new Team();
        Team team2 = new Team();
        TeamStatistics team1Stats = new TeamStatistics();
        TeamStatistics team2Stats = new TeamStatistics();

        team1.setTeamStatistics(team1Stats);
        team2.setTeamStatistics(team2Stats);

        matchHistory.setTeam1(team1);
        matchHistory.setTeam2(team2);

        matchHistory.setScoreOfTeam1(23);
        matchHistory.setScoreOfTeam2(30);

        matchHistory.score();

        assertEquals(1, team2.getTeamStatistics().getWins());
    }

    @Test
    public void testTeam1Looses() {
        MatchHistory matchHistory = new MatchHistory();
        Team team1 = new Team();
        Team team2 = new Team();
        TeamStatistics team1Stats = new TeamStatistics();
        TeamStatistics team2Stats = new TeamStatistics();

        team1.setTeamStatistics(team1Stats);
        team2.setTeamStatistics(team2Stats);

        matchHistory.setTeam1(team1);
        matchHistory.setTeam2(team2);

        matchHistory.setScoreOfTeam1(23);
        matchHistory.setScoreOfTeam2(30);

        matchHistory.score();
        assertEquals(1, team1.getTeamStatistics().getLooses());

    }

    @Test
    public void testDraw() {
        MatchHistory matchHistory = new MatchHistory();
        Team team1 = new Team();
        Team team2 = new Team();
        TeamStatistics team1Stats = new TeamStatistics();
        TeamStatistics team2Stats = new TeamStatistics();

        team1.setTeamStatistics(team1Stats);
        team2.setTeamStatistics(team2Stats);

        matchHistory.setTeam1(team1);
        matchHistory.setTeam2(team2);

        matchHistory.setScoreOfTeam1(50);
        matchHistory.setScoreOfTeam2(50);

        matchHistory.score();

        assertEquals(1, team1.getTeamStatistics().getDraws());
        assertEquals(1, team2.getTeamStatistics().getDraws());
    }

    @Test
    public void testSummaryOfTeamStatistics() {

        MatchHistory matchHistory = new MatchHistory();
        Team team1 = new Team();
        Team team2 = new Team();
        TeamStatistics team1Stats = new TeamStatistics();
        TeamStatistics team2Stats = new TeamStatistics();

        team1.setTeamStatistics(team1Stats);
        team2.setTeamStatistics(team2Stats);

        matchHistory.setTeam1(team1);
        matchHistory.setTeam2(team2);

        team1.getTeamStatistics().setWins(10);
        team1.getTeamStatistics().setLooses(20);
        team1.getTeamStatistics().setDraws(5);

        team2.getTeamStatistics().setWins(7);
        team2.getTeamStatistics().setLooses(9);
        team2.getTeamStatistics().setDraws(1);

        matchHistory.setScoreOfTeam1(90);
        matchHistory.setScoreOfTeam2(10);

        matchHistory.score();

        assertEquals(11, team1.getTeamStatistics().getWins());
        assertEquals(10, team2.getTeamStatistics().getLooses());
        assertEquals(13.5, team1.getTeamStatistics().getPoints(), 0.0001);
        assertEquals(7.5, team2.getTeamStatistics().getPoints(), 0.0001);
    }
}

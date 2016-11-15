package domain;

import com.neovisionaries.i18n.CountryCode;
import domain.model.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by L on 11.11.2016.
 */
public class ModelTest {

    @Test
    public void testPlayerRatio() {
        Player player = new Player();
        PlayerStats playerStats = new PlayerStats();
        player.setPlayerStats(playerStats);
        player.getPlayerStats().setKills(10);
        player.getPlayerStats().setDeaths(20);
        assertEquals(0.5, player.getPlayerStats().getRatio(), 0.001);
    }

    @Test
    public void testTeamPoints() {
        TeamStats teamStats = new TeamStats();
        teamStats.setWins(3);
        teamStats.setDraws(2);
        assertEquals(4, teamStats.getPoints(), 0.001);
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
    public void testTeamCountry(){
        Team team = new Team();
        team.setCountry(CountryCode.US.getName());
        assertEquals(CountryCode.US.getName(), team.getCountry());
    }

    @Test
    public void testScoreBoardKillsInMatch() {

        HistoryOfMatch historyOfMatch = new HistoryOfMatch();
        Player player = new Player();
        PlayerStats playerStats = new PlayerStats();
        ScoreBoard scoreBoard = new ScoreBoard();

        player.setPlayerStats(playerStats);
        scoreBoard.setPlayer(player);
        historyOfMatch.setScoreBoard(scoreBoard);

        scoreBoard.setKillsInMatch(10);
        scoreBoard.setPlayerStats();

        assertEquals(10, historyOfMatch.getScoreBoard().getKillsInMatch());
        assertEquals(10, historyOfMatch.getScoreBoard().getPlayer().getPlayerStats().getKills());

    }

    @Test
    public void testScoreBoardDeathsInMatch() {
        HistoryOfMatch historyOfMatch = new HistoryOfMatch();
        Player player = new Player();
        PlayerStats playerStats = new PlayerStats();
        ScoreBoard scoreBoard = new ScoreBoard();

        player.setPlayerStats(playerStats);
        scoreBoard.setPlayer(player);
        historyOfMatch.setScoreBoard(scoreBoard);

        scoreBoard.setDeathsInMatch(20);
        scoreBoard.setPlayerStats();

        assertEquals(20, historyOfMatch.getScoreBoard().getDeathsInMatch());
        assertEquals(20, historyOfMatch.getScoreBoard().getPlayer().getPlayerStats().getDeaths());

    }

    @Test
    public void testPlayerRatioAfterMatch() {
        HistoryOfMatch historyOfMatch = new HistoryOfMatch();
        Player player = new Player();
        PlayerStats playerStats = new PlayerStats();
        ScoreBoard scoreBoard = new ScoreBoard();

        player.setPlayerStats(playerStats);
        scoreBoard.setPlayer(player);
        historyOfMatch.setScoreBoard(scoreBoard);

        playerStats.setKills(5);
        playerStats.setDeaths(15);
        scoreBoard.setKillsInMatch(10);
        scoreBoard.setDeathsInMatch(15);
        scoreBoard.setPlayerStats();

        assertEquals(0.5, player.getPlayerStats().getRatio(), 0.001);
    }

    @Test
    public void testTeam1Win() {

        HistoryOfMatch historyOfMatch = new HistoryOfMatch();
        Team team1 = new Team();
        Team team2 = new Team();
        TeamStats team1Stats = new TeamStats();
        TeamStats team2Stats = new TeamStats();

        team1.setTeamStats(team1Stats);
        team2.setTeamStats(team2Stats);

        historyOfMatch.setTeam1(team1);
        historyOfMatch.setTeam2(team2);

        historyOfMatch.setScoreOfTeam1(43);
        historyOfMatch.setScoreOfTeam2(20);

        historyOfMatch.score();

        assertEquals(1, team1.getTeamStats().getWins());
        assertEquals(1, team2.getTeamStats().getLooses());

    }

    @Test
    public void testTeam2Win() {

        HistoryOfMatch historyOfMatch = new HistoryOfMatch();
        Team team1 = new Team();
        Team team2 = new Team();
        TeamStats team1Stats = new TeamStats();
        TeamStats team2Stats = new TeamStats();

        team1.setTeamStats(team1Stats);
        team2.setTeamStats(team2Stats);

        historyOfMatch.setTeam1(team1);
        historyOfMatch.setTeam2(team2);

        historyOfMatch.setScoreOfTeam1(23);
        historyOfMatch.setScoreOfTeam2(30);

        historyOfMatch.score();

        assertEquals(1, team2.getTeamStats().getWins());
        assertEquals(1, team1.getTeamStats().getLooses());
    }

    @Test
    public void testDraw() {
        HistoryOfMatch historyOfMatch = new HistoryOfMatch();
        Team team1 = new Team();
        Team team2 = new Team();
        TeamStats team1Stats = new TeamStats();
        TeamStats team2Stats = new TeamStats();

        team1.setTeamStats(team1Stats);
        team2.setTeamStats(team2Stats);

        historyOfMatch.setTeam1(team1);
        historyOfMatch.setTeam2(team2);

        historyOfMatch.setScoreOfTeam1(50);
        historyOfMatch.setScoreOfTeam2(50);

        historyOfMatch.score();

        assertEquals(1, team1.getTeamStats().getDraws());
        assertEquals(1, team1.getTeamStats().getDraws());
    }

    @Test
    public void testSummaryOfTeamStatistics() {

        HistoryOfMatch historyOfMatch = new HistoryOfMatch();
        Team team1 = new Team();
        Team team2 = new Team();
        TeamStats team1Stats = new TeamStats();
        TeamStats team2Stats = new TeamStats();

        team1.setTeamStats(team1Stats);
        team2.setTeamStats(team2Stats);

        historyOfMatch.setTeam1(team1);
        historyOfMatch.setTeam2(team2);

        team1.getTeamStats().setWins(10);
        team1.getTeamStats().setLooses(20);
        team1.getTeamStats().setDraws(5);

        team2.getTeamStats().setWins(7);
        team2.getTeamStats().setLooses(9);
        team2.getTeamStats().setDraws(1);

        historyOfMatch.setScoreOfTeam1(90);
        historyOfMatch.setScoreOfTeam2(10);

        historyOfMatch.score();

        assertEquals(11, team1.getTeamStats().getWins());
        assertEquals(10, team2.getTeamStats().getLooses());
        assertEquals(13.5, team1.getTeamStats().getPoints(), 0.0001);
        assertEquals(7.5, team2.getTeamStats().getPoints(), 0.0001);
    }
}

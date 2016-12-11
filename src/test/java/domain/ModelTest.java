package domain;

import com.neovisionaries.i18n.CountryCode;
import domain.model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author L on 11.11.2016.
 */

public class ModelTest {

    private Player player = new Player();
    private PlayerStatistics playerStatistics = new PlayerStatistics();
    private Team team1 = new Team();
    private Team team2 = new Team();
    private TeamStatistics teamStatistics = new TeamStatistics();
    private MatchHistory matchHistory = new MatchHistory();
    private MatchScoreBoard scoreBoard = new MatchScoreBoard();

    @Before
    public void playerStatisticsSetUp() throws Exception {
        playerStatistics.setKills(10);
        playerStatistics.setDeaths(20);
    }


    @Before
    public void playerSetUp() throws Exception {
        player.setPlayerStatistics(playerStatistics);
        player.setSteamId("STEAM_0:1:38401525");
        player.setCountry(CountryCode.PL.getName());

    }

    @Before
    public void teamStatisticsSetUp() throws Exception {
        teamStatistics.setWins(3);
        teamStatistics.setDraws(2);
    }

    @Before
    public void teamSetUp() throws Exception {

        team1.setCountry(CountryCode.US.getName());

    }

    @Before
    public void matchScoreBoardSetUp() throws Exception {
        scoreBoard.setPlayer(player);
        scoreBoard.setKillsInMatch(10);
        scoreBoard.setDeathsInMatch(20);
        playerSetUp();
        scoreBoard.setPlayerStats();
    }

    @Before
    public void matchHistorySetUp() throws Exception {
        matchHistory.setMatchScoreBoard(scoreBoard);
        teamStatisticsSetUp();
        matchHistory.setTeam1(team1);
        matchHistory.setTeam2(team2);
        matchHistory.setScoreOfTeam1(43);
        matchHistory.setScoreOfTeam2(20);

    }

    @Test
    public void testPlayerRatio() {

        assertEquals(0.5, player.getPlayerStatistics().getRatio(), 0.001);
    }

    @Test
    public void testTeamPoints() {

        assertEquals(4, teamStatistics.getPoints(), 0.001);
    }

    @Test
    public void testSteamId() {
        assertEquals("STEAM_0:1:38401525", player.getSteamId());
    }

    @Test
    public void testPlayerCountry() {
        assertEquals(CountryCode.PL.getName(), player.getCountry());
    }

    @Test
    public void testTeamCountry() {

        assertEquals(CountryCode.US.getName(), team1.getCountry());
    }

    @Test
    public void testScoreBoardKillsInMatch() {

        assertEquals(10, matchHistory.getMatchScoreBoard().getKillsInMatch());

    }

    @Test
    public void testPlayerKillsInScoreBoard() {

        assertEquals(10, matchHistory.getMatchScoreBoard().getPlayer().getPlayerStatistics().getKills());

    }

    @Test
    public void testScoreBoardDeathsInMatch() {

        assertEquals(20, matchHistory.getMatchScoreBoard().getDeathsInMatch());

    }

    @Test
    public void testPlayerDeathsInScoreBoard() {

        assertEquals(20, matchHistory.getMatchScoreBoard().getPlayer().getPlayerStatistics().getDeaths());

    }

    @Test
    public void testPlayerRatioAfterMatch() {

        assertEquals(0.5, player.getPlayerStatistics().getRatio(), 0.001);
    }

}

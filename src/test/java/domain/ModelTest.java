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
    private Team team1 = new Team();
    private Team team2 = new Team();
    private TeamStatistics teamStatistics = new TeamStatistics();
    private MatchHistory matchHistory = new MatchHistory();



    @Before
    public void playerSetUp() throws Exception {
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
    public void matchHistorySetUp() throws Exception {
        teamStatisticsSetUp();
        matchHistory.setTeam1(team1);
        matchHistory.setTeam2(team2);
        matchHistory.setScoreOfTeam1(43);
        matchHistory.setScoreOfTeam2(20);

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




}

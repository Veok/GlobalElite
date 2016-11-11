package globalElite;

import com.neovisionaries.i18n.CountryCode;
import globalElite.model.BalanceOfPlayer;
import globalElite.model.BalanceOfTeam;
import globalElite.model.Player;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Created by L on 11.11.2016.
 */
public class ModelTest {

    @Test
    public void testPlayerRatio(){
        BalanceOfPlayer balanceOfPlayer = new BalanceOfPlayer();
        balanceOfPlayer.setKills(10);
        balanceOfPlayer.setDeaths(20);
        double ratio = balanceOfPlayer.getRatio();
        assertEquals(0.5, ratio, 0.001);
    }

    @Test
    public void testTeamPoints(){
        BalanceOfTeam balanceOfTeam = new BalanceOfTeam();
        balanceOfTeam.setWins(3);
        balanceOfTeam.setDraws(2);
        double points = balanceOfTeam.getPoints();
        assertEquals(4, points, 0.001);
    }

    @Test
    public void testSteamId(){
        Player player = new Player();
        player.setSteamId("STEAM_0:1:38401525");
        assertEquals(true, player.validateSteamId());
    }

    @Test
    public void testPlayerCountry(){
        Player player = new Player();
        player.setCountry(CountryCode.PL.getName());
        assertEquals(CountryCode.PL.getName(), player.getCountry());
    }

}

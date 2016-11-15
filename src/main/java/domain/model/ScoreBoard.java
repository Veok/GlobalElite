package domain.model;

/**
 * Created by L on 13.11.2016.
 */
public class ScoreBoard {

    private Player player;
    private int killsInMatch;
    private int deathsInMatch;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getKillsInMatch() {
        return killsInMatch;
    }

    public void setKillsInMatch(int killsInMatch) {
        this.killsInMatch = killsInMatch;
    }

    public int getDeathsInMatch() {
        return deathsInMatch;
    }

    public void setDeathsInMatch(int deathsInMatch) {
        this.deathsInMatch = deathsInMatch;
    }


    public void setPlayerStats() {

        player.getPlayerStats().setKills(player.getPlayerStats().getKills() + killsInMatch);
        player.getPlayerStats().setDeaths(player.getPlayerStats().getDeaths() + deathsInMatch);

    }

}

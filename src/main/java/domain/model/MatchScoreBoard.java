package domain.model;

/**
 * @author L on 13.11.2016.
 */
public class MatchScoreBoard implements IHaveId {

    private int id;
    private Player player;
    private int killsInMatch;
    private int deathsInMatch;


    public Player getPlayer() {
        return player;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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



        player.getGeneralPlayerStats().setKills(player.getGeneralPlayerStats().getKills() + killsInMatch);
        player.getGeneralPlayerStats().setDeaths(player.getGeneralPlayerStats().getDeaths() + deathsInMatch);

    }

}

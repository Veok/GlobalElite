package globalElite.model;

/**
 * Created by L on 10.11.2016.
 */
public class ScoreOfPlayer {

    private int kills;
    private int deaths;
    private Player playerNick;
    private Team teamName;

    public ScoreOfPlayer() {
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public Player getPlayerNick() {
        return playerNick;
    }

    public void setPlayerNick(Player playerNick) {
        this.playerNick = playerNick;
    }

    public Team getTeamName() {
        return teamName;
    }

    public void setTeamName(Team teamName) {
        this.teamName = teamName;
    }
}

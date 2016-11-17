package domain.model;

/**
 * @author L on 13.11.2016.
 */
public class PlayerStats implements IHaveId {

    private int id;
    private int kills;
    private int deaths;
    private double ratio;

    public PlayerStats() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getRatio() {
        ratio = (double) kills / (double) deaths;
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}

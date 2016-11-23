package domain.model;

/**
 * @author L on 10.11.2016.
 */
public class Team implements IHaveId {

    private int id;
    private String name;
    private String country;
    private Player players;
    private GeneralTeamStats generalTeamStats;

    public Team() {
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Player getPlayers() {
        return players;
    }

    public void setPlayers(Player players) {
        this.players = players;
    }

    public GeneralTeamStats getGeneralTeamStats() {
        return generalTeamStats;
    }

    public void setGeneralTeamStats(GeneralTeamStats generalTeamStats) {
        this.generalTeamStats = generalTeamStats;
    }


}

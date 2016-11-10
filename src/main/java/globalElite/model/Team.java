package globalElite.model;

/**
 * Created by L on 10.11.2016.
 */
public class Team {

    private String name;
    private Country country;
    private Player players;
    private BalanceOfTeam balanceOfTeam;
    private HistoryOfMatch history;

    public Team() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Player getPlayers() {
        return players;
    }

    public void setPlayers(Player players) {
        this.players = players;
    }

    public BalanceOfTeam getBalanceOfTeam() {
        return balanceOfTeam;
    }

    public void setBalanceOfTeam(BalanceOfTeam balanceOfTeam) {
        this.balanceOfTeam = balanceOfTeam;
    }

    public HistoryOfMatch getHistory() {
        return history;
    }

    public void setHistory(HistoryOfMatch history) {
        this.history = history;
    }
}

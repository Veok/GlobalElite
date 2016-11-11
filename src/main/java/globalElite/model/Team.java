package globalElite.model;

import java.util.Locale;

/**
 * Created by L on 10.11.2016.
 */
public class Team {

    private String name;
    private Locale country;
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


    public Locale getCountry() {
        return country;
    }

    public void setCountry(Locale country) {
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

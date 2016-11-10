package globalElite.model;

import java.util.Date;

/**
 * Created by L on 10.11.2016.
 */
public class Player {

    private String nick;
    private Date dateOfBirth;
    private Team team;
    private Country country;
    private String steamId;
    private BalanceOfPlayer balanceOfPlayer;

    public Player() {
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getSteamId() {
        return steamId;
    }

    public void setSteamId(String steamId) {
        this.steamId = steamId;
    }

    public BalanceOfPlayer getBalanceOfPlayer() {
        return balanceOfPlayer;
    }

    public void setBalanceOfPlayer(BalanceOfPlayer balanceOfPlayer) {
        this.balanceOfPlayer = balanceOfPlayer;
    }
}

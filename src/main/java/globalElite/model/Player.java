package globalElite.model;

import com.neovisionaries.i18n.CountryCode;

import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by L on 10.11.2016.
 */
public class Player {

    private String nick;
    private Date dateOfBirth;
    private Team team;
    private String country;
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


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
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

    public boolean validateSteamId() {
        if (steamId == null) {
            return false;
        }

        String regx = "STEAM_[0-1]:[0-1]:\\d{1,8}";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(steamId);
        return matcher.find();
    }


}

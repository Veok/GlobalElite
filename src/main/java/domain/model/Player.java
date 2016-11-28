package domain.model;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author L on 10.11.2016.
 */
public class Player implements IHaveId {

    private int id;
    private String nick;
    private Date dateOfBirth;
    private String country;
    private String steamId;
    private PlayerStatistics playerStatistics;


    public Player() {

    }

    private boolean validateSteamId() {
        if (steamId == null) {
            return false;
        }

        String regx = "STEAM_[0-1]:[0-1]:\\d{1,8}";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(steamId);
        return matcher.find();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public PlayerStatistics getPlayerStatistics() {
        return playerStatistics;
    }

    public void setPlayerStatistics(PlayerStatistics playerStatistics) {
        this.playerStatistics = playerStatistics;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSteamId() {
        if (validateSteamId()) {
            return steamId;
        } else
            return "Wrong Steam ID";
    }

    public void setSteamId(String steamId) {

        this.steamId = steamId;

    }


}

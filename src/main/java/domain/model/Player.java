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
    private String country;
    private String steamId;
    private String dateOfBirth;
    private PlayerStatistics playerStatistics;
    private Team team;

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



    public Team getTeam() {
        return  team;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setTeam(Team team) {
        this.team = team;
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

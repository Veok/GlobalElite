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
    private GeneralPlayerStats generalPlayerStats;


    public Player() {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public GeneralPlayerStats getGeneralPlayerStats() {
        return generalPlayerStats;
    }

    public void setGeneralPlayerStats(GeneralPlayerStats generalPlayerStats) {
        this.generalPlayerStats = generalPlayerStats;
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
        return steamId;
    }

    public void setSteamId(String steamId) {
        this.steamId = steamId;
    }


}

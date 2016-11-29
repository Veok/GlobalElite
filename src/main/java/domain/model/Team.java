package domain.model;

import java.util.List;

/**
 * @author L on 10.11.2016.
 */
public class Team implements IHaveId {

    private int id;
    private String name;
    private String country;
    private TeamStatistics teamStatistics;

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


    public TeamStatistics getTeamStatistics() {
        return teamStatistics;
    }

    public void setTeamStatistics(TeamStatistics teamStatistics) {
        this.teamStatistics = teamStatistics;
    }


}

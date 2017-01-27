package domain.model;

import javax.inject.Named;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author L on 10.11.2016.
 */


@Entity
@NamedQueries({
        @NamedQuery(name = "team.all", query = "SELECT t from Team t"),
        @NamedQuery(name = "team.id", query = "SELECT t from Team t where t.id=:teamId"),
        @NamedQuery(name= "team.name", query = "SELECT t from Team t where t.name=:teamName")
})
public class Team implements IHaveId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String country;
    @OneToOne
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

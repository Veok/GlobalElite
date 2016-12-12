package dao.repositories;

import domain.model.Team;

import java.util.List;

/**
 * @author L on 18.11.2016.
 */
public interface ITeamRepository extends IRepository<Team> {

    List<Team> withName(String name);

    List<Team> withCountry(String country);


}

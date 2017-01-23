package hdao.repositories;

import domain.model.Team;

import java.util.List;

/**
 * @author L on 23.01.2017.
 */
public interface IHTeamRepository extends IHRepository<Team> {

    Team withName(String name);

    List<Team> withCountry(String country);
    void getById(int id);

}

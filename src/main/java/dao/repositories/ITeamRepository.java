package dao.repositories;

import domain.model.Player;
import domain.model.Team;

import java.util.List;

/**
 * @author L on 18.11.2016.
 */
public interface ITeamRepository extends IRepository<Team> {

    public List<Team> withName(String name);

    public List<Team> withCountry(String country);

    public List<Team> withPlayer(Player player);
}

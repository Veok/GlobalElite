package dao.repositories;

import domain.model.Player;
import domain.model.Team;

import java.util.Date;
import java.util.List;

/**
 * @author L on 18.11.2016.
 */
public interface IPlayerRepository extends IRepository<Player> {

    List<Player> withNick(String nick);

    List<Player> withCountry(String country);

    List<Player> withDateOfBirth(Date dob);

    List<Player> withTeam(Team team);


}

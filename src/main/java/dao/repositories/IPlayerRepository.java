package dao.repositories;

import domain.model.Player;

import java.util.List;

/**
 * @author L on 18.11.2016.
 */
public interface IPlayerRepository extends IRepository<Player> {

    public List<Player> nick(String nick);
    public  List<Player> country(String player);
    public  List<Player> steamId(String player);

}

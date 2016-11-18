package dao.repositories;

import domain.model.Player;
import domain.model.ScoreBoard;

import java.util.List;

/**
 * @author L on 18.11.2016.
 */
public interface IScoreBoardRepository extends IRepository<ScoreBoard> {

    public List<ScoreBoard> player(Player player);
    public  List<ScoreBoard> killsInMatch(int killsInMatch);
    public  List<ScoreBoard> deathsInMatch(int deathInMatch);
}

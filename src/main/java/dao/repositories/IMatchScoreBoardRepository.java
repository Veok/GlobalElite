package dao.repositories;

import domain.model.MatchScoreBoard;

import java.util.List;

/**
 * @author L on 18.11.2016.
 */
public interface IMatchScoreBoardRepository extends IRepository<MatchScoreBoard> {

    public List<MatchScoreBoard> withKillsInMatch(int killsInMatch);

    public List<MatchScoreBoard> withDeathsInMatch(int deathInMatch);

}

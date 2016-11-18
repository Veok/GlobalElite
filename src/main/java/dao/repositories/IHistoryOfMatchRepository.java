package dao.repositories;

import domain.model.HistoryOfMatch;
import domain.model.Maps;
import domain.model.ScoreBoard;
import domain.model.Team;

import java.util.List;

/**
 * @author L on 17.11.2016.
 */
public interface IHistoryOfMatchRepository extends IRepository<HistoryOfMatch>{

    public List<HistoryOfMatch> teams(Team team);
    public List<HistoryOfMatch> scores(ScoreBoard scoreBoard);
    public List<HistoryOfMatch> maps(Maps map);
}

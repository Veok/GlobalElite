package dao.repositories;

import domain.model.TeamStatistics;

import java.util.List;

/**
 * @author L on 18.11.2016.
 */
public interface ITeamStatisticsRepository extends IRepository<TeamStatistics> {

    public List<TeamStatistics> withWins(int wins);

    public List<TeamStatistics> withLooses(int looses);

    public List<TeamStatistics> withDraws(int draws);

    public List<TeamStatistics> withPoints(double points);
}

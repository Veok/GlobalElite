package dao.repositories;

import domain.model.TeamStatistics;

import java.util.List;

/**
 * @author L on 18.11.2016.
 */
public interface ITeamStatisticsRepository extends IRepository<TeamStatistics> {

    List<TeamStatistics> withWins(int wins);

    List<TeamStatistics> withLooses(int looses);

    List<TeamStatistics> withDraws(int draws);

    List<TeamStatistics> withPoints(double points);
}

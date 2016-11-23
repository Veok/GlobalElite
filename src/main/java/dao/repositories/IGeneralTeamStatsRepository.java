package dao.repositories;

import domain.model.GeneralTeamStats;

import java.util.List;

/**
 * @author L on 18.11.2016.
 */
public interface IGeneralTeamStatsRepository extends IRepository<GeneralTeamStats> {

    public List<GeneralTeamStats> withWins(int wins);

    public List<GeneralTeamStats> withLooses(int looses);

    public List<GeneralTeamStats> withDraws(int draws);

    public List<GeneralTeamStats> withPoints(double points);
}

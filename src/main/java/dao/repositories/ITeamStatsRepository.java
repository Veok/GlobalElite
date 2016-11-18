package dao.repositories;

import domain.model.TeamStats;

import java.util.List;

/**
 * @author L on 18.11.2016.
 */
public interface ITeamStatsRepository extends  IRepository<TeamStats> {

    public List<TeamStats> wins(int wins);
    public List<TeamStats> looses(int looses);
    public List<TeamStats> draws(int draws);
    public List<TeamStats> points(double points);
}

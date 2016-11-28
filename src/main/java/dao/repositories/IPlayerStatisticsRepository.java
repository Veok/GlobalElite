package dao.repositories;

import domain.model.PlayerStatistics;

import java.util.List;

/**
 * @author L on 18.11.2016.
 */
public interface IPlayerStatisticsRepository extends IRepository<PlayerStatistics> {

    public List<PlayerStatistics> kills(int kills);

    public List<PlayerStatistics> deaths(int deaths);

    public List<PlayerStatistics> ratio(double ratio);
}

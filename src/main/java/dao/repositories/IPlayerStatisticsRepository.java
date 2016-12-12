package dao.repositories;

import domain.model.PlayerStatistics;

import java.util.List;

/**
 * @author L on 18.11.2016.
 */
public interface IPlayerStatisticsRepository extends IRepository<PlayerStatistics> {

    List<PlayerStatistics> kills(int kills);

    List<PlayerStatistics> deaths(int deaths);

    List<PlayerStatistics> ratio(double ratio);
}

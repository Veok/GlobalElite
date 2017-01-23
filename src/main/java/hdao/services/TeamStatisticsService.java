package hdao.services;

import domain.model.TeamStatistics;
import hdao.repositories.IHTeamStatisticsRepository;

import java.util.List;

/**
 * @author L on 23.01.2017.
 */
public class TeamStatisticsService extends EntityService<TeamStatistics> implements IHTeamStatisticsRepository {

    public TeamStatisticsService() {
    }

    @Override
    public List<TeamStatistics> getAll(String entityName) {
        return super.getAll(entityName);
    }

    @Override
    public void update(TeamStatistics teamStatistics) {
        super.update(teamStatistics);
    }

    @Override
    public void add(TeamStatistics teamStatistics) {
        super.add(teamStatistics);
    }

    @Override
    public void delete(TeamStatistics teamStatistics) {
        super.delete(teamStatistics);
    }
}

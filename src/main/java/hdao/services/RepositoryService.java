package hdao.services;

import hdao.repositories.*;

/**
 * @author L on 23.01.2017.
 */
public class RepositoryService implements IHRepositoryCatalog {

    @Override
    public IHTeamRepository teams() {
        return new TeamService();
    }

    @Override
    public IHMatchHistoryRepository history() {
        return new MatchHistoryService();
    }

    @Override
    public IHTeamStatisticsRepository teamStats() {
        return new TeamStatisticsService();
    }

    @Override
    public IHGameMapRepository gameMaps() {
        return new GameMapService();
    }
}

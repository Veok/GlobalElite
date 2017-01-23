package hdao.repositories;

/**
 * @author L on 23.01.2017.
 */
public interface IHRepositoryCatalog {

    IHTeamRepository teams();
    IHMatchHistoryRepository history();
    IHTeamStatisticsRepository teamStats();
    IHGameMapRepository gameMaps();

}

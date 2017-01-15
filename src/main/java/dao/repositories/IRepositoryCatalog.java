package dao.repositories;

import java.sql.SQLException;

/**
 * @author L on 23.11.2016.
 */
public interface IRepositoryCatalog {

    IPlayerRepository players();

    ITeamRepository teams();

    IEnumDictionariesRepository dictionaries();

    IMatchHistoryRepository history();

    ITeamStatisticsRepository teamsStats();

    IGameMapRepository maps();

    void saveAndClose();

}

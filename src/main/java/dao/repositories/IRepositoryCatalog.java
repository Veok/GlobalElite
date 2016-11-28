package dao.repositories;

import java.sql.SQLException;

/**
 * @author L on 23.11.2016.
 */
public interface IRepositoryCatalog {

    IPlayerRepository players();

    ITeamRepository teams();

    IEnumDictionariesRepository dictionaries();

    IMatchScoreBoardRepository scoreboards();

    IMatchHistoryRepository history();

    IGeneralPlayerStatsRepository playersStats();

    IGeneralTeamStatsRepository teamsStats();

    void save() throws SQLException;

}

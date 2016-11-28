package dao;

import dao.mappers.*;
import dao.repositories.*;
import dao.uow.IUnitOfWork;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author L on 27.11.2016.
 */
public class RepositoryCatalog implements IRepositoryCatalog {

    private Connection connection;
    private IUnitOfWork uow;
    private PlayerRepositoryMapper playerRepositoryMapper;
    private PlayerStatisticsMapper playerStatisticsMapper;
    private TeamMapper teamMapper;
    private EnumDictionaryMapper enumDictionaryMapper;
    private MatchScoreBoardMapper matchScoreBoardMapper;
    private MatchHistoryMapper matchHistoryMapper;
    private TeamStatisticsMapper teamStatisticsMapper;


    public RepositoryCatalog(Connection connection, IUnitOfWork uow) {
        super();
        this.connection = connection;
        this.uow = uow;
    }

    @Override
    public IPlayerStatisticsRepository playersStats() {
        return new PlayerStatisticsRepository(connection, playerRepositoryMapper, uow);
    }

    @Override
    public IPlayerRepository players() {
        return new PlayerRepository(connection, playerRepositoryMapper, uow);
    }

    @Override
    public ITeamRepository teams() {
        return new TeamRepository(connection, teamMapper, uow);
    }

    @Override
    public IEnumDictionariesRepository dictionaries() {
        return new EnumDictionariesRepository(connection, enumDictionaryMapper, uow);
    }

    @Override
    public IMatchScoreBoardRepository scoreboards() {
        return new MatchScoreBoardRepository(connection, matchScoreBoardMapper, uow);
    }

    @Override
    public IMatchHistoryRepository history() {
        return new MatchHistoryRepository(connection, matchHistoryMapper, uow);
    }


    @Override
    public ITeamStatisticsRepository teamsStats() {
        return new TeamStatisticsRepository(connection, teamStatisticsMapper, uow);
    }

    @Override
    public void save() throws SQLException {
        uow.saveChanges();
        connection.close();
    }
}

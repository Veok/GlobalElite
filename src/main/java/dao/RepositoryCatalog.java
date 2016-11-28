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

    public RepositoryCatalog(Connection connection, IUnitOfWork uow) {
        super();
        this.connection = connection;
        this.uow = uow;
    }

    @Override
    public IPlayerStatisticsRepository playersStats() {
        return new PlayerStatisticsRepository(connection, new PlayerStatisticsMapper(), uow);
    }

    @Override
    public IPlayerRepository players() {
        return new PlayerRepository(connection, new PlayerRepositoryMapper(), uow);
    }

    @Override
    public ITeamRepository teams() {
        return new TeamRepository(connection, new TeamMapper(), uow);
    }

    @Override
    public IEnumDictionariesRepository dictionaries() {
        return new EnumDictionariesRepository(connection, new EnumDictionaryMapper(), uow);
    }

    @Override
    public IMatchScoreBoardRepository scoreboards() {
        return new MatchScoreBoardRepository(connection, new MatchScoreBoardMapper(), uow);
    }

    @Override
    public IMatchHistoryRepository history() {
        return new MatchHistoryRepository(connection, new MatchHistoryMapper(), uow);
    }


    @Override
    public ITeamStatisticsRepository teamsStats() {
        return new TeamStatisticsRepository(connection, new PlayerStatisticsMapper(), uow);
    }

    @Override
    public void save() throws SQLException {
        uow.saveChanges();
        connection.close();
        connection = null;
    }
}

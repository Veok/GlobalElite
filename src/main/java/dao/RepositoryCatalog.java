package dao;

import dao.mappers.*;
import dao.repositories.*;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author L on 27.11.2016.
 */
public class RepositoryCatalog implements IRepositoryCatalog {

    private Connection connection;
    private IUnitOfWork uow;
    private PlayerRepositoryMapper playerRepositoryMapper = new PlayerRepositoryMapper();
    private PlayerStatisticsMapper playerStatisticsMapper = new PlayerStatisticsMapper();
    private TeamMapper teamMapper = new TeamMapper();
    private EnumDictionaryMapper enumDictionaryMapper = new EnumDictionaryMapper();
    private MatchScoreBoardMapper matchScoreBoardMapper = new MatchScoreBoardMapper();
    private MatchHistoryMapper matchHistoryMapper = new MatchHistoryMapper();
    private TeamStatisticsMapper teamStatisticsMapper = new TeamStatisticsMapper();
    private GameMapMapper gameMapMapper = new GameMapMapper();

    public RepositoryCatalog(String connection) throws SQLException {
        super();
       this.connection = DriverManager.getConnection(connection);
       this.uow = new UnitOfWork(this.connection);
    }

    @Override
    public IPlayerStatisticsRepository playersStats() {
        return new PlayerStatisticsRepository(connection, playerStatisticsMapper, uow);
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
    public IGameMapRepository maps() {
        return new GameMapRepository(connection, gameMapMapper, uow);
    }

    @Override
    public void saveAndClose() {

        try{
            uow.saveChanges();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

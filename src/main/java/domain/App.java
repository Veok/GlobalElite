package domain;

import dao.RepositoryCatalog;
import dao.repositories.IRepositoryCatalog;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;
import domain.model.GeneralPlayerStats;
import domain.model.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class App {
    public static void main(String[] args) {
        String url = "jdbc:hsqldb:hsql://localhost/workdb";
        GeneralPlayerStats generalPlayerStats = new GeneralPlayerStats();
        Player player = new Player();
        generalPlayerStats.setKills(10);
        player.setNick("Veok");
        try {


            Connection connection = DriverManager.getConnection(url);
            IUnitOfWork uow = new UnitOfWork(connection);

            IRepositoryCatalog catalog = new RepositoryCatalog(connection, uow);
            catalog.players().add(player);
            uow.saveChanges();
            List<Player> playerList = catalog.players().withNick("Veok");
            for (Player playerFromDb : playerList) {
                System.out.println(playerFromDb.getNick());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

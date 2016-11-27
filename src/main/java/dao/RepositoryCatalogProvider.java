package dao;

import dao.repositories.IRepositoryCatalog;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author L on 27.11.2016.
 */
public class RepositoryCatalogProvider {

    private static String url = "jdbc:hsqldb:hsql://localhost/workdb";

    public static IRepositoryCatalog catalog() {
        try {
            Connection connection = DriverManager.getConnection(url);
            IUnitOfWork uow = new UnitOfWork(connection);
            IRepositoryCatalog catalog = new RepositoryCatalog(connection, uow);
            return catalog;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

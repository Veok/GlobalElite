package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by L on 13.11.2016.
 */
public abstract class RepositoryBase {

    private Connection connection;


    public Connection getConnection() {
        return connection;
    }

    protected RepositoryBase(Connection connection) {
        this.connection = connection;
        createTableIfNotExists();
    }


    protected abstract String createTableSql();

    protected abstract String tableName();


    private void createTableIfNotExists() {
        try {
            Statement createTable = this.connection.createStatement();

            boolean tableExists = false;

            ResultSet rs = connection.getMetaData().getTables(null, null, null, null);

            while (rs.next()) {
                if (rs.getString("Table_Name").equalsIgnoreCase(tableName())) {
                    tableExists = true;
                    break;
                }
            }
            if (!tableExists)
                createTable.executeUpdate(createTableSql());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

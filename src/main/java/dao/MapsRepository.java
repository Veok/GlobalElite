package dao;

import domain.model.Maps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by L on 13.11.2016.
 */
public class MapsRepository extends RepositoryBase {

    private String insertSql = "INSERT INTO MAPS(name) VALUES (?)";
    private String selectByIdSql = "SELECT * FROM MAPS WHERE id=?";
    private String deleteSql = "DELETE FROM MAPS WHERE id=?";
    private String getAllSql = "SELECT * FROM MAPS";
    private String updateSql = "UPDATE MAPS SET name=? WHERE id=?";


    private PreparedStatement insert;
    private PreparedStatement selectById;
    private PreparedStatement delete;
    private PreparedStatement getAll;
    private PreparedStatement update;

    public MapsRepository(Connection connection) {
        super(connection);

        try {
            insert = connection.prepareStatement(insertSql);
            selectById = connection.prepareStatement(selectByIdSql);
            delete = connection.prepareStatement(deleteSql);
            getAll = connection.prepareStatement(getAllSql);
            update = connection.prepareStatement(updateSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(Maps map) {
        try {
            insert.setString(1, map.name());
            insert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int mapId) {

        try {
            delete.setInt(1, mapId);
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAll() {
        try {
            ResultSet resultSet = getAll.executeQuery();
            while (resultSet.next()) {
                int map_id = resultSet.getInt("id");
                String map_name = resultSet.getString("name");
                System.out.println(map_id + "" + map_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setUpdate(int id, Maps name1) {

        try {
            update.setString(1, name1.name());
            update.setInt(2, id);
            update.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Maps get(int mapId) {

        try {
            selectById.setInt(1, mapId);
            ResultSet resultSet = selectById.executeQuery();
            while (resultSet.next()) {
                return Maps.getByName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected String createTableSql() {
        return "" + "CREATE TABLE MAPS("
                + "id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,"
                + "name varchar(25)," + ")";
    }

    @Override
    protected String tableName() {
        return "MAPS";
    }
}

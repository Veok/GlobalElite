package dao;

import dao.mappers.IMapResultSetIntoEntity;
import dao.repositories.IRepository;
import dao.uow.Entity;
import dao.uow.IUnitOfWork;
import dao.uow.IUnitOfWorkRepository;
import domain.model.IHaveId;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author L on 13.11.2016.
 */
public abstract class RepositoryBase<TEntity extends IHaveId> implements IRepository<TEntity>, IUnitOfWorkRepository {


    protected Connection connection;

    protected PreparedStatement insert;
    protected PreparedStatement selectById;
    protected PreparedStatement update;
    protected PreparedStatement delete;
    protected PreparedStatement selectAll;
    protected PreparedStatement selectLastId;
    protected IUnitOfWork uow;
    protected IMapResultSetIntoEntity<TEntity> mapper;

    public Connection getConnection() {
        return connection;
    }

    protected RepositoryBase(Connection connection,
                             IMapResultSetIntoEntity<TEntity> mapper, IUnitOfWork uow) {
        this.connection = connection;
        this.uow = uow;
        try {
            this.mapper = mapper;
            createTableIfNotExists();
            insert = connection.prepareStatement(insertSql());
            selectById = connection.prepareStatement(selectByIdSql());
            update = connection.prepareStatement(updateSql());
            delete = connection.prepareStatement(deleteSql());
            selectAll = connection.prepareStatement(selectAllSql());
            selectLastId = connection.prepareStatement(selectLastIdSql());


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<TEntity> getAll() {
        try {
            ResultSet rs = selectAll.executeQuery();
            List<TEntity> result = new ArrayList<TEntity>();
            while (rs.next()) {
                result.add(mapper.map(rs));
            }
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public TEntity get(int id) {
        try {
            selectById.setInt(1, id);
            ResultSet rs = selectById.executeQuery();
            while (rs.next()) {
                return mapper.map(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    public void add(TEntity entity) {
        Entity ent = new Entity(this);
        ent.setEntity(entity);
        uow.markAsNew(ent);
    }

    public void delete(TEntity entity) {
        Entity ent = new Entity(this);
        ent.setEntity(entity);
        uow.markAsDeleted(ent);
    }

    public void update(TEntity entity) {
        Entity ent = new Entity(this);
        ent.setEntity(entity);
        uow.markAsChanged(ent);
    }

    public void persistUpdate(Entity entity) {
        try {
            TEntity ent = (TEntity) entity.getEntity();
            setUpdate(ent);
            update.setInt(3, ent.getId());
            update.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void persistAdd(Entity entity) {
        try {
            setInsert((TEntity) entity.getEntity());
            insert.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void persistDelete(Entity entity) {
        try {
            delete.setInt(1, ((TEntity) entity.getEntity()).getId());
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getLastId() {
        try {
            ResultSet rs = selectLastId.executeQuery();
            while (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public List<TEntity> searchByInt(int value, PreparedStatement statement) {
        List<TEntity> tEntities = new ArrayList<>();
        try {
            statement.setInt(1, value);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tEntities.add(mapper.map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tEntities;
    }

    public List<TEntity> searchByString(String name, PreparedStatement statement) {
        List<TEntity> tEntities = new ArrayList<>();
        try {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                tEntities.add(mapper.map(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tEntities;
    }

    protected String selectByIdSql() {
        return "SELECT * FROM " + tableName() + " WHERE id=?";
    }

    protected String deleteSql() {
        return "DELETE FROM " + tableName() + " WHERE id=?";
    }

    protected String selectAllSql() {
        return "SELECT * FROM " + tableName();
    }

    private void createTableIfNotExists() throws SQLException {
        Statement createTable = this.connection.createStatement();

        boolean tableExists = false;

        ResultSet rs = connection.getMetaData().getTables(null, null, null,
                null);

        while (rs.next()) {
            if (rs.getString("Table_Name").equalsIgnoreCase(tableName())) {
                tableExists = true;
                break;
            }
        }
        if (!tableExists)
            createTable.executeUpdate(createTableSql());
    }

    protected String selectLastIdSql() {
        return "SELECT max(id) AS id FROM " + tableName();
    }

    protected abstract String insertSql();

    protected abstract String updateSql();

    protected abstract void setUpdate(TEntity entity) throws SQLException;

    protected abstract void setInsert(TEntity entity) throws SQLException;

    protected abstract String createTableSql();

    protected abstract String tableName();
}

package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author L on 16.11.2016.
 */
public interface IMapResultSetIntoEntity<TEntity> {

    public TEntity map(ResultSet rs) throws SQLException;

}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDao<E, K> {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "arbuser";
    private static final String PASSWORD = "1234";

    protected static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public abstract List<E> getAll() throws SQLException;

    public abstract E update(E entity);

    public abstract E getEntityById(K id) throws SQLException;

    public abstract boolean delete(K id) throws SQLException;

    public abstract boolean create(E entity);


}

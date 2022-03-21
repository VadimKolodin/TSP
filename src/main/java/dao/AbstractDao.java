package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public abstract class AbstractDao<E, K> {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "ARBUSER";
    private static final String PASSWORD = "1234";

    protected static Connection connection;

    static {
        try {
            Locale.setDefault(Locale.ENGLISH);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public abstract List<E> getAll() throws SQLException;

    public abstract boolean update(E entity) throws SQLException;

    public abstract E getEntityById(K id) throws SQLException;

    public abstract boolean delete(K id) throws SQLException;

    public abstract boolean create(E entity) throws SQLException;

    public abstract Integer getNewId() throws SQLException;
}

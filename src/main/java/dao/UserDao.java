package dao;

import models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao<User, Integer>{

    private static String SELECT_ALL_USERS = "select * from users";
    private static String SELECT_USER_BY_ID = "select * from users where user_id = ?";
    private static String DELETE_USER_BY_ID = "delete from users where user_id = ?";


    @Override
    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();
        PreparedStatement pr =connection.prepareStatement(SELECT_ALL_USERS);
        ResultSet resultSet = pr.executeQuery();
        while(resultSet.next()){
            users.add(new User(
                    resultSet.getInt("USER_ID"),
                    resultSet.getString("LOGIN"),
                    Integer.parseInt(resultSet.getString("PASSWORD")),
                    resultSet.getInt("ACCESS_LVL")));
        }
        pr.close();
        return users;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public User getEntityById(Integer id) throws SQLException {
        User user = null;
        PreparedStatement pr = connection.prepareStatement(SELECT_USER_BY_ID);
        pr.setInt(1, id);
        ResultSet resultSet = pr.executeQuery();
        if (resultSet.next()){
            user = new User(
                    resultSet.getInt("USER_ID"),
                    resultSet.getString("LOGIN"),
                    Integer.parseInt(resultSet.getString("PASSWORD")),
                    resultSet.getInt("ACCESS_LVL"));
        }
        pr.close();
        return user;
    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        PreparedStatement pr =connection.prepareStatement(DELETE_USER_BY_ID);
        pr.setInt(1, id);
        int result = pr.executeUpdate();
        return result > 0;
    }

    @Override
    public boolean create(User entity) {
        return false;
    }
}

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
    private static String INSERT_USER = "insert into users values(uid_seq.NEXTVAL, ?, ?, ?)";
    private static String UPDATE_USER_BY_ID = "update users set login = ?, password = ?, access_lvl = ? where id = ?";


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
    public boolean update(User user) throws SQLException {
        if (user.getId()==null){
            return false;
        }
        PreparedStatement pr = connection.prepareStatement(UPDATE_USER_BY_ID);
        User oldUser = getEntityById(user.getId());
        pr.setString(1, (user.getName()==null)?oldUser.getName():user.getName());
        pr.setString(2, (user.getPassword()==null)?oldUser.getPassword().toString():user.getPassword().toString());
        pr.setInt(3, (user.getAccessLevel()==null)?oldUser.getAccessLevel():user.getAccessLevel());
        pr.setInt(4, user.getId());
        int result = pr.executeUpdate();

        return result > 0;
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
    public boolean create(User user) throws SQLException {
        PreparedStatement pr = connection.prepareStatement(INSERT_USER);
        pr.setString(1, user.getName());
        pr.setString(2, Integer.toString(user.getPassword()));
        pr.setInt(3, user.getAccessLevel());
        int result = pr.executeUpdate();
        return result > 0;
    }
}

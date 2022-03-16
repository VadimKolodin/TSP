package dao;

import models.User;
import models.UserInfo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao<User, Integer>{

    private static final String UID_SEQ_NEXTVAL = "select uid_seq.nextval from DUAL";

    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String SELECT_USER_BY_ID = "select * from users where uid = ?";
    private static final String DELETE_USER_BY_ID = "delete from users where uid = ?";
    private static final String INSERT_USER = "insert into users values(?, ?, ?)";
    private static final String UPDATE_USER_BY_ID = "update users set login = ?, password = ? where uid = ?";

    private static final String SELECT_USER_INFO_BY_ID = "select * from user_info where uid = ?";
    private static final String DELETE_USER_INFO_BY_ID = "delete from user_info where uid = ?";
    private static final String INSERT_USER_INFO = "insert into user_info values(?, ?, ?, ?)";
    private static final String UPDATE_USER_INFO_BY_ID = "update user_info set name = ?, regd = ?, desc = ? where uid = ?";


    @Override
    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();
        PreparedStatement pr = connection.prepareStatement(SELECT_ALL_USERS);
        ResultSet resultSet = pr.executeQuery();
        while(resultSet.next()){
            users.add(new User(
                    resultSet.getInt("UID"),
                    resultSet.getString("LOGIN"),
                    Integer.parseInt(resultSet.getString("PASSWORD"))
            ));
        }
        pr.close();
        return users;
    }

    //user
    @Override
    public boolean update(User user) throws SQLException {
        if (user.getUid()==null)
            throw new IllegalArgumentException("Null id");
        PreparedStatement pr = connection.prepareStatement(UPDATE_USER_BY_ID);
        User oldUser = getEntityById(user.getUid());

        if (user.getLogin() == null){
            pr.setString(1, oldUser.getLogin());
        } else {
            pr.setString(1, user.getLogin());
        }

        if (user.getPassword() == null){
            pr.setString(2, oldUser.getPassword().toString());
        } else {
            pr.setString(2, user.getPassword().toString());
        }

        pr.setInt(3, user.getUid());

        int result = pr.executeUpdate();
        return result > 0;
    }

    //userInfo
    public boolean updateUserInfo(UserInfo info) throws SQLException {
        if (info.getUid()==null)
            throw new IllegalArgumentException("Null id");
        PreparedStatement pr = connection.prepareStatement(UPDATE_USER_INFO_BY_ID);
        UserInfo oldInfo = getUserInfoById(info.getUid());

        if (info.getName() == null){
            pr.setString(1, oldInfo.getName());
        } else {
            pr.setString(1, info.getName());
        }

        if (info.getRegd() == null){
            pr.setDate(2, Date.valueOf(oldInfo.getRegd()));
        } else {
            pr.setDate(2, Date.valueOf(info.getRegd()));
        }

        if (info.getDesc() == null){
            pr.setString(3, oldInfo.getDesc());
        } else {
            pr.setString(3, info.getDesc());
        }

        pr.setInt(4, info.getUid());

        int result = pr.executeUpdate();
        return result > 0;
    }

    // user
    @Override
    public User getEntityById(Integer id) throws SQLException {
        User user = null;
        PreparedStatement pr = connection.prepareStatement(SELECT_USER_BY_ID);
        pr.setInt(1, id);
        ResultSet resultSet = pr.executeQuery();
        if (resultSet.next()){
            user = new User(
                    resultSet.getInt("UID"),
                    resultSet.getString("LOGIN"),
                    Integer.parseInt(resultSet.getString("PASSWORD"))
            );
        }
        pr.close();
        return user;
    }

    // userInfo
    public UserInfo getUserInfoById(Integer id) throws SQLException{
        UserInfo info = null;
        PreparedStatement pr = connection.prepareStatement(SELECT_USER_INFO_BY_ID);
        pr.setInt(1, id);
        ResultSet resultSet = pr.executeQuery();
        if (resultSet.next()){
            info = new UserInfo(
                    resultSet.getInt("UID"),
                    resultSet.getString("NAME"),
                    resultSet.getDate("REGD").toLocalDate(),
                    resultSet.getString("DESC")
            );
        }
        pr.close();
        return info;
    }

    //user + userInfo
    @Override
    public boolean delete(Integer id) throws SQLException {
        PreparedStatement prSub = connection.prepareStatement(DELETE_USER_INFO_BY_ID);
        PreparedStatement pr = connection.prepareStatement(DELETE_USER_BY_ID);
        prSub.setInt(1, id);
        pr.setInt(1, id);

        int result = pr.executeUpdate() * prSub.executeUpdate();
        return result > 0;
    }

    @Override
    public Integer getNewId() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UID_SEQ_NEXTVAL);
        ResultSet rs = ps.executeQuery();
        Integer uid = null;
        if(rs.next())
            uid = rs.getInt(1);
        return uid;
    }

    //user
    @Override
    public boolean create(User user) throws SQLException {

        PreparedStatement pr = connection.prepareStatement(INSERT_USER);
        pr.setInt(1, user.getUid());
        pr.setString(2, user.getLogin());
        pr.setString(3, user.getPassword().toString());


        int result = pr.executeUpdate();
        return result > 0;
    }

    //userInfo
    boolean createUserInfo(UserInfo info) throws SQLException {
        PreparedStatement pr = connection.prepareStatement(INSERT_USER_INFO);
        pr.setInt(1, info.getUid());
        pr.setString(2, info.getName());
        pr.setDate(3, Date.valueOf(info.getRegd()));
        pr.setString(4, info.getDesc());

        int result = pr.executeUpdate();
        return result > 0;
    }
}

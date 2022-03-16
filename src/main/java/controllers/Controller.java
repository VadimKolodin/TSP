package controllers;

import dao.UserDao;
import dto.User;
import dto.UserInfo;

import java.sql.SQLException;
import java.util.List;

public class Controller {
    private static UserDao userDao;

    static {
        userDao = new UserDao();
    }

    public static List<User> getAllUsers() throws SQLException {
        return userDao.getAll();
    }

    public static User getUserById(Integer id) throws SQLException {
        return userDao.getEntityById(id);
    }

    public static UserInfo getUserInfoById(Integer id) throws SQLException {
        return userDao.getUserInfoById(id);
    }

    public static boolean deleteUserById(Integer id) throws SQLException {
        boolean result = false;
        result = userDao.deleteUserInfoById(id);
        result = result && userDao.delete(id);
        return result;
    }

    public static boolean createUser(User user, UserInfo info) throws SQLException {
        boolean result = false;
        Integer uid = userDao.getNewId();

        user.setUid(uid);
        info.setUid(uid);

        result = userDao.create(user);
        result = result && userDao.createUserInfo(info);
        return result;
    }

    public static boolean changeUser(User user, UserInfo info) throws SQLException {
        boolean result = true;

        if (user.getUid() != info.getUid()){
            throw new IllegalArgumentException("Controller: changeUser: user uid and info uid do not match");
        }

        if (user != null){
            result = userDao.update(user);
        }
        if (info != null){
            result = result && userDao.updateUserInfo(info);
        }
        return result;
    }
}

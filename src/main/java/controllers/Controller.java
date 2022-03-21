package controllers;

import dao.EstateDao;
import dao.IncomeDao;
import dao.OutcomeDao;
import dao.UserDao;
import dto.EstateStatus;
import dto.RealEstate;
import dto.User;
import dto.UserInfo;

import java.sql.SQLException;
import java.util.List;

public class Controller {
    private static UserDao userDao;
    private static EstateDao estateDao;
    private static IncomeDao incomeDao;
    private static OutcomeDao outcomeDao;

    static {
        userDao = new UserDao();
        estateDao = new EstateDao();
        incomeDao = new IncomeDao();
        outcomeDao = new OutcomeDao();
    }

    public static List<User> getAllUsers() throws SQLException {
        return userDao.getAll();
    }
    public static User getUserById(Integer usid) throws SQLException {
        if (usid == null){
            throw new IllegalArgumentException("User id is null");
        }
        return userDao.getEntityById(usid);
    }
    public static UserInfo getUserInfoById(Integer usid) throws SQLException {
        if (usid == null){
            throw new IllegalArgumentException("User id is null");
        }
        return userDao.getUserInfoById(usid);
    }
    public static boolean deleteUserById(Integer usid) throws SQLException {
        if (usid == null){
            throw new IllegalArgumentException("User id is null");
        }
        boolean result = false;
        result = userDao.deleteUserInfoById(usid);
        result = result && userDao.delete(usid);
        return result;
    }
    public static boolean createUser(User user, UserInfo info) throws SQLException {
        if (user == null){
            throw new IllegalArgumentException("User object cannot be null");
        }
        if (info == null){
            throw new IllegalArgumentException("UserInfo object cannot be null");
        }

        Integer uid = userDao.getNewId();

        user.setUid(uid);
        info.setUid(uid);

        boolean result = userDao.create(user);
        if (!result){
            return false;
        }
        result = result && userDao.createUserInfo(info);
        return result;
    }
    public static boolean changeUser(User user, UserInfo info) throws SQLException {
        boolean result = true;
        if (user!= null && info!=null) {
            if (user.getUid() != info.getUid()) {
                throw new IllegalArgumentException("Controller: changeUser: user uid and info uid do not match");
            }
        }

        if (user != null){
            if (user.getUid() == null){
                throw new IllegalArgumentException("User id cannot be null");
            }
            result = userDao.update(user);
        }
        if (info != null){
            if (info.getUid() == null){
                throw new IllegalArgumentException("UserInfo id cannot be null");
            }
            result = result && userDao.updateUserInfo(info);
        }
        return result;
    }

    public static List<RealEstate> getAllEstatesByUserId(Integer usid) throws SQLException {
        if (usid == null){
            throw new IllegalArgumentException("User id is null");
        }
        return estateDao.getAllFromUser(usid);
    }
    public static RealEstate getRealEstateById(Integer eid) throws SQLException{
        if (eid == null){
            throw new IllegalArgumentException("Estate id is null");
        }
        return estateDao.getEntityById(eid);
    }
    public static EstateStatus getEstateStatusById(Integer eid) throws SQLException {
        if (eid == null){
            throw new IllegalArgumentException("Estate id is null");
        }
        return estateDao.getEstateStatusById(eid);
    }
    public static boolean createRealEstate(RealEstate estate, EstateStatus status) throws SQLException {
        if (estate == null){
            throw new IllegalArgumentException("realEstate object cannot be null");
        }
        if (status == null){
            throw new IllegalArgumentException("EstateStatus cannot be null");
        }
        int eid = estate.getEid();
        estate.setEid(eid);
        status.setEid(eid)
        ;
        boolean result = estateDao.create(estate);
        if(!result){
            return false;
        }
        result = estateDao.createEstateStatus(status);
        return result;
    }
    public static boolean changeRealEstate(RealEstate estate, EstateStatus status) throws SQLException {
        if (estate !=null && status!=null) {
            if (estate.getEid() != status.getEid()) {
                throw new IllegalArgumentException("Estate ids do not match");
            }
        }
        boolean result = true;

        if (estate != null){
            if (estate.getEid() == null){
                throw new IllegalArgumentException("Estate id is null");
            }
            result = estateDao.update(estate);
        }
        if (status!=null){
            if (status.getEid() == null){
                throw new IllegalArgumentException("EstateStatus id is null");
            }
            result=result&estateDao.updateEstateStatus(status);
        }
        return result;
    }
    /*public static boolean deleteRealEstate(Integer eid){

    }*/
}

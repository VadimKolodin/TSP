package models;


import models.dto.User;
import models.dto.UserInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model {
    private HashMap<Integer, User> users = new HashMap<>();

    public List<User>getAllUsers(){
        return new ArrayList<User>(users.values());
    }

    public User getUser(int usid){
        return users.get(usid);
    }
    public void addUser(User user, UserInfo info){
        user.setInfo(info);
        users.put(user.getUid(), user);
    }
    public void deleteUser(int usid){
        users.remove(usid);
    }
}

package dto;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private Integer uid;
    private String login;
    private Integer password;

    public User(Integer id, String name, Integer password) {
        this.uid = id;
        this.login = name;
        this.password = password;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return uid == user.uid && password == user.password  && Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, login, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + uid +
                ", name='" + login + '\'' +
                ", password=" + password +
                '}';
    }
}

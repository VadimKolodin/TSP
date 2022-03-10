package models;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private int id;
    private String name;
    private int password;
    private int accessLevel;

    public User(int id, String name, int password, int accessLevel) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && password == user.password && accessLevel == user.accessLevel && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, accessLevel);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password=" + password +
                ", accessLevel=" + accessLevel +
                '}';
    }
}

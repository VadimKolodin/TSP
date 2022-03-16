package models;

import java.sql.Blob;
import java.util.Objects;

public class RealEstate {
    private int eid;
    private int uid;
    private String type;
    private String address;
    private Blob image;

    public RealEstate(int eid, int uid, String type, String address, Blob image) {
        this.eid = eid;
        this.uid = uid;
        this.type = type;
        this.address = address;
        this.image = image;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealEstate that = (RealEstate) o;
        return eid == that.eid && uid == that.uid && Objects.equals(type, that.type) && Objects.equals(address, that.address) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eid, uid, type, address, image);
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "eid=" + eid +
                ", uid='" + uid + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", image=" + image +
                '}';
    }
}

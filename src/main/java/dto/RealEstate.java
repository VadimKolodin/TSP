package dto;

import java.util.Objects;

public class RealEstate {
    private Integer eid;
    private Integer usid;
    private String type;
    private String address;

    public RealEstate(Integer eid, Integer uid, String type, String address) {
        this.eid = eid;
        this.usid = uid;
        this.type = type;
        this.address = address;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
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

    public Integer getUsid() {
        return usid;
    }

    public void setUsid(Integer usid) {
        this.usid = usid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealEstate that = (RealEstate) o;
        return eid == that.eid && usid == that.usid && Objects.equals(type, that.type) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eid, usid, type, address);
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "eid=" + eid +
                ", uid='" + usid + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", image=" +
                '}';
    }
}

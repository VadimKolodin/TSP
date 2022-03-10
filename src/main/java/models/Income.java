package models;

import java.time.LocalDate;
import java.util.Objects;

public class Income {
    private int iid;
    private int eid;
    private LocalDate idate;
    private String name;
    private double value;
    private String comment;

    public Income(int iid, int eid, LocalDate idate, String name, double value, String comment) {
        this.iid = iid;
        this.eid = eid;
        this.idate = idate;
        this.name = name;
        this.value = value;
        this.comment = comment;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public LocalDate getIdate() {
        return idate;
    }

    public void setIdate(LocalDate idate) {
        this.idate = idate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Income income = (Income) o;
        return iid == income.iid && eid == income.eid && Double.compare(income.value, value) == 0 && Objects.equals(idate, income.idate) && Objects.equals(name, income.name) && Objects.equals(comment, income.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iid, eid, idate, name, value, comment);
    }

    @Override
    public String toString() {
        return "Income{" +
                "iid=" + iid +
                ", eid=" + eid +
                ", idate=" + idate +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", comment='" + comment + '\'' +
                '}';
    }
}

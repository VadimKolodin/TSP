package models;

import java.time.LocalDate;
import java.util.Objects;

public class Outcome {
    private int oid;
    private int eid;
    private LocalDate odate;
    private String name;
    private double value;
    private String comment;

    public Outcome(int oid, int eid, LocalDate odate, String name, double value, String comment) {
        this.oid = oid;
        this.eid = eid;
        this.odate = odate;
        this.name = name;
        this.value = value;
        this.comment = comment;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public LocalDate getOdate() {
        return odate;
    }

    public void setOdate(LocalDate odate) {
        this.odate = odate;
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
        Outcome outcome = (Outcome) o;
        return oid == outcome.oid && eid == outcome.eid && Double.compare(outcome.value, value) == 0 && Objects.equals(odate, outcome.odate) && Objects.equals(name, outcome.name) && Objects.equals(comment, outcome.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oid, eid, odate, name, value, comment);
    }

    @Override
    public String toString() {
        return "Outcome{" +
                "oid=" + oid +
                ", eid=" + eid +
                ", odate=" + odate +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", comment='" + comment + '\'' +
                '}';
    }
}

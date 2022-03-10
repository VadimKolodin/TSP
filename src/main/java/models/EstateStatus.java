package models;

import java.time.LocalDate;
import java.util.Objects;

public class EstateStatus {
    private int eid;
    private int purchasePrice;
    private int soldPrice;
    private LocalDate purchaseDate;
    private LocalDate soldDate;
    private boolean isSold;

    public EstateStatus(int eid, int purchasePrice, int soldPrice, LocalDate purchaseDate, LocalDate soldDate, boolean isSold) {
        this.eid = eid;
        this.purchasePrice = purchasePrice;
        this.soldPrice = soldPrice;
        this.purchaseDate = purchaseDate;
        this.soldDate = soldDate;
        this.isSold = isSold;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(int soldPrice) {
        this.soldPrice = soldPrice;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(LocalDate soldDate) {
        this.soldDate = soldDate;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstateStatus that = (EstateStatus) o;
        return eid == that.eid && purchasePrice == that.purchasePrice && soldPrice == that.soldPrice && isSold == that.isSold && Objects.equals(purchaseDate, that.purchaseDate) && Objects.equals(soldDate, that.soldDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eid, purchasePrice, soldPrice, purchaseDate, soldDate, isSold);
    }

    @Override
    public String toString() {
        return "EstateStatus{" +
                "eid=" + eid +
                ", purchasePrice=" + purchasePrice +
                ", soldPrice=" + soldPrice +
                ", purchaseDate=" + purchaseDate +
                ", soldDate=" + soldDate +
                ", isSold=" + isSold +
                '}';
    }
}

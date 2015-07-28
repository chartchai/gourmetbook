package camt.se331.gourmetbooker.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType.*;
import org.hibernate.annotations.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 * Created by Punjasin on 28/7/2558.
 */
@Entity
public class Table {
    @Id
    @GeneratedValue
    Long id;
    int seatnum;
    @ManyToOne(fetch= FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    Restaurant shop;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Table table = (Table) o;

        if (seatnum != table.seatnum) return false;
        if (id != null ? !id.equals(table.id) : table.id != null) return false;
        return !(shop != null ? !shop.equals(table.shop) : table.shop != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + seatnum;
        result = 31 * result + (shop != null ? shop.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSeatnum() {
        return seatnum;
    }

    public void setSeatnum(int seatnum) {
        this.seatnum = seatnum;
    }

    public Restaurant getShop() {
        return shop;
    }

    public void setShop(Restaurant shop) {
        this.shop = shop;
    }

    public Table() {
    }

    public Table(int seatnum, Restaurant shop) {
        this.seatnum = seatnum;
        this.shop = shop;
    }
}

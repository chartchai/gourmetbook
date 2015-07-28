package camt.se331.gourmetbooker.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

import javax.persistence.Entity;

/**
 * Created by Punjasin on 25/7/2558.
 */
@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    Long id;
    String name;
    int numtable;
    boolean approve;
    @OneToOne(fetch= FetchType.EAGER)
   @Cascade(CascadeType.ALL)
    User owner;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Restaurant(String name, int numtable, boolean approve, User owner) {
        this.name = name;
        this.numtable = numtable;
        this.approve = approve;
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restaurant that = (Restaurant) o;

        if (numtable != that.numtable) return false;
        if (approve != that.approve) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;

        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + numtable;
        result = 31 * result + (approve ? 1 : 0);
        return result;
    }

    public Restaurant() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumtable() {
        return numtable;
    }

    public void setNumtable(int numtable) {
        this.numtable = numtable;
    }

    public boolean isApprove() {
        return approve;
    }

    public void setApprove(boolean approve) {
        this.approve = approve;
    }
}

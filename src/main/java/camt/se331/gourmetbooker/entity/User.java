package camt.se331.gourmetbooker.entity;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dto on 4/19/2015.
 */
@Entity
   public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    private String email;
    private String password;
    private String firstname;
    private String surname;
    private String Address;
    private String Tel;
    private double money;
    @OneToOne(fetch= FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    Restaurant shop;
    @OneToOne(fetch= FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    Request request;

    @ManyToMany(fetch= FetchType.EAGER)
    // Cascade and CascadeType must be the org.hibernate.annotation
    @Cascade(CascadeType.ALL)
    private Set<Role> roles = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (Double.compare(user.money, money) != 0) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (firstname != null ? !firstname.equals(user.firstname) : user.firstname != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (Address != null ? !Address.equals(user.Address) : user.Address != null) return false;
        if (Tel != null ? !Tel.equals(user.Tel) : user.Tel != null) return false;
        if (shop != null ? !shop.equals(user.shop) : user.shop != null) return false;
        if (request != null ? !request.equals(user.request) : user.request != null) return false;
        return !(roles != null ? !roles.equals(user.roles) : user.roles != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (Address != null ? Address.hashCode() : 0);
        result = 31 * result + (Tel != null ? Tel.hashCode() : 0);
        temp = Double.doubleToLongBits(money);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (shop != null ? shop.hashCode() : 0);
        result = 31 * result + (request != null ? request.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", Address='" + Address + '\'' +
                ", Tel='" + Tel + '\'' +
                ", money=" + money +
                ", shop=" + shop +
                ", request=" + request +
                ", roles=" + roles +
                '}';
    }

    public User(String username, String email, String password, String firstname, String surname, String address, String tel, double money, Restaurant shop, Request request, Set<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.surname = surname;
        Address = address;
        Tel = tel;
        this.money = money;
        this.shop = shop;
        this.request = request;
        this.roles = roles;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Restaurant getShop() {
        return shop;
    }

    public void setShop(Restaurant shop) {
        this.shop = shop;
    }



    public User(String username, String email, String password, String firstname, String surname, String address, String tel, double money, Set<Role> roles) {
        this.username = username;

        this.email = email;
        this.password = password;

        Address = address;
        Tel = tel;
        this.money = money;
        this.roles = roles;
    }

    public User() {
        money=0;
        System.out.println(toString());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

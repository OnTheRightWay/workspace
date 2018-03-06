package com.nys.domain;

import com.nys.domain.Orders;

import java.util.List;

public class User {
    private int uid;
    private String uname;
    private String gender;
    private List<Orders> orders;

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", gender='" + gender + '\'' +
                ", orders=" + orders +
                '}';
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public User() {
    }

    public User(int uid, String uname, String gender) {
        this.uid = uid;
        this.uname = uname;
        this.gender = gender;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

package com.lanou.domain;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
    private String username;
    private List<Orders> ordersList;
    private int id;

    @Override
    public String toString() {
        return "User{" +
                " id=" + id +
                ", username='" + username + '\'' +
                ", ordersList=" + ordersList +

                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User() {
    }

    public User(String username, List<Orders> ordersList) {
        this.username = username;
        this.ordersList = ordersList;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
}

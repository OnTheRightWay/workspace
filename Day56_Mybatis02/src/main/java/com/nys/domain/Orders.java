package com.nys.domain;

import java.util.Date;
import java.util.List;

public class Orders {
    private int id;
    private int user_id;
    private int number;
    private List<Items> items;

    private List<OrderDetail> orderDetails;

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", number=" + number +
                ", orderDetails=" + orderDetails +
                ", user=" + user +
                '}';
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //    private Date createtime;
//    private String note;

    public Orders() {
    }

    public Orders(int id, int user_id, int number) {

        this.id = id;
        this.user_id = user_id;
        this.number = number;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

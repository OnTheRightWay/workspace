package com.lanou.domain;

import java.util.List;

public class Orders {
    private int id;
    private int number;
    private int user_id;
    private List<OrderDetail> orderDetails;

    public Orders() {
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", number=" + number +
                ", user_id=" + user_id +
                ", orderDetails=" + orderDetails +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Orders(int id, int number, List<OrderDetail> orderDetails) {
        this.id = id;
        this.number = number;
        this.orderDetails = orderDetails;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
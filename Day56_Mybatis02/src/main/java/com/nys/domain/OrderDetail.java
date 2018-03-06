package com.nys.domain;

import java.util.List;

public class OrderDetail {
    private int id;
    private int orders_id;
    private int items_id;
    private Items items;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orders_id=" + orders_id +
                ", items_id=" + items_id +
                ", items=" + items +
                '}';
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public OrderDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public int getItems_id() {
        return items_id;
    }

    public void setItems_id(int items_id) {
        this.items_id = items_id;
    }

    public OrderDetail(int id, int orders_id, int items_id) {

        this.id = id;
        this.orders_id = orders_id;
        this.items_id = items_id;
    }
}

package com.lanou.domain;

public class OrderDetail {
    private Items items;
    private int id;

    public OrderDetail() {
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "items=" + items +
                ", id=" + id +
                '}';
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderDetail(Items items, int id) {
        this.items = items;
        this.id = id;

    }
}

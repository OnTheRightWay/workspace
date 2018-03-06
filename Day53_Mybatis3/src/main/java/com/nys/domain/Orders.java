package com.nys.domain;

import com.nys.domain.Items;

import java.util.Date;
import java.util.List;

public class Orders {
    private int oid;
    private String oname;
    private Date date;
    private int uid;
    private List<Items> items;

    @Override
    public String toString() {
        return "Orders{" +
                "oid=" + oid +
                ", oname='" + oname + '\'' +
                ", date=" + date +
                ", uid=" + uid +
                ", items=" + items +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public Orders() {
    }

    public Orders(int oid, String oname, Date date) {
        this.oid = oid;
        this.oname = oname;
        this.date = date;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

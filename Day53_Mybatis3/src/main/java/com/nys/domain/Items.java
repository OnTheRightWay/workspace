package com.nys.domain;

import com.nys.domain.Cargo;

import java.util.List;

public class Items {
    private int iid;
    private int oid;
    private int cid;

    private Cargo cargo;

    @Override
    public String toString() {
        return "Items{" +
                "iid=" + iid +
                ", oid=" + oid +
                ", cid=" + cid +
                ", cargos=" + cargo +
                '}';
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Items() {
    }

    public Items(int iid, int oid, int cid) {
        this.iid = iid;
        this.oid = oid;
        this.cid = cid;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}

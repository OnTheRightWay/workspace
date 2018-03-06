package com.nys.domain;

public class Cargo {
    private int cid;
    private String cname;

    @Override
    public String toString() {
        return "Cargo{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }

    public Cargo() {
    }

    public Cargo(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}

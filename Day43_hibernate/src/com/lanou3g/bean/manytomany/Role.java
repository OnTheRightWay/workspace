package com.lanou3g.bean.manytomany;

import java.util.HashSet;
import java.util.Set;

public class Role {
    private String rid;
    private String rname;
    //显示初始化
    private Set<User> users = new HashSet<>();

    @Override
    public String toString() {
        return "Role{" +
                "rid='" + rid + '\'' +
                ", rname='" + rname + '\'' +
                '}';
    }

    public Role() {
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}

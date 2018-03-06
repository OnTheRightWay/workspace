package com.nys.mybatis映射文件.domain;

import java.util.List;

public class UserQueryV0 {
    private UserExt userExt;
    private List<Integer> idList;

    public UserQueryV0(UserExt userExt) {
        this.userExt = userExt;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public UserExt getUserExt() {
        return userExt;
    }

    public void setUserExt(UserExt userExt) {
        this.userExt = userExt;
    }
}

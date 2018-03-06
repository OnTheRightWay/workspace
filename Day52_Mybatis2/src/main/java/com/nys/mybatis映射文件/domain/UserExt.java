package com.nys.mybatis映射文件.domain;

public class UserExt {
    private String gender;
    private String username;

    public UserExt() {
    }


    @Override
    public String toString() {
        return "UserQueryV0{" +
                "gender='" + gender + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public UserExt(String gender, String username) {
        this.gender = gender;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

package com.nys.domain;

public class Classes {
    private String name;
    private String gender;
    private int id;

    @Override
    public String toString() {
        return "Classes{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", id=" + id +
                '}';
    }

    public Classes(String name, String gender, int id) {
        this.name = name;
        this.gender = gender;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Classes() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classes(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }
}

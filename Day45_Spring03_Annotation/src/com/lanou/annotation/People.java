package com.lanou.annotation;

public class People {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        System.out.println(this.getClass().getName());
        return "People{" +
                "name='" + name + '\'' +
                '}';
    }
}

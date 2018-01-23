package com.lanou.di;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Person {
    private String name;
    private int age;
    private String gender;
    private Car car;
    private List list;
    private Set set;
    private Map map;
    private Properties properties;
    private Object[] objects;

    public Person() {

    }

    public void init(){
        properties=new Properties();
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("1.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Person(String name, int age, String gender, Car car, List list, Set set, Map map, Properties properties, Object[] objects) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.car = car;
        this.list = list;
        this.set = set;
        this.map = map;
        this.properties = properties;
        this.objects = objects;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", car=" + car +"\n"+
                ", list=" + list +
                ", set=" + set +"\n"+
                ", map=" + map +
                ", properties=" + properties +"\n"+
                ", objects=" + Arrays.toString(objects) +
                '}';
    }

    public Person(String name, int age, String gender, Car car) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }
}

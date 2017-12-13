package test;

import java.lang.reflect.Method;

class Person{
    public void sleep(){
        System.out.println("睡觉");
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("test.Person");
        Object obj = cls.newInstance();
        Method sleep = cls.getMethod("sleep");
        sleep.invoke(obj);


    }
}

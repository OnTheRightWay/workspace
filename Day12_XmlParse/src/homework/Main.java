package homework;

import org.dom4j.DocumentException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Person person=null;
        Person person1 = new Person("张三",18,"男","工人");
        Person person2 = new Person("李四",19,"女","老板");
        Person person3 = new Person("王五",20,"男","厨师");
        Person person4 = new Person("赵六",22,"女","医生");

        try {
            XMLDemo.XMLWrite(person1);
            XMLDemo.XMLWrite(person2);
            XMLDemo.XMLWrite(person3);
            XMLDemo.XMLWrite(person4);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            person=XMLDemo.readXML("赵六");
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        System.out.println(person);

    }
}

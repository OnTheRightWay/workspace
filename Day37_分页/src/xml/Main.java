package xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        XStream xStream = new XStream(new DomDriver());
        User user = new User("liSi","123");
        User user1 = new User("zhangSan","123");
        User user2 = new User("wangWu","123");
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        Person person = new Person(users);

//        xStream.toXML(person,new FileOutputStream("src/person.xml"));

        try {
            Person p = (Person) xStream.fromXML(new FileInputStream("src/person.xml"));
            List<User> users1 = p.getUsers();
            System.out.println(users1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

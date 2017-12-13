package homework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class 反序列化实例 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fr = new FileInputStream("");
        ObjectInputStream ois = new ObjectInputStream(fr);
        Object o = ois.readObject();
        System.out.println(o);

        ois.close();
    }
}

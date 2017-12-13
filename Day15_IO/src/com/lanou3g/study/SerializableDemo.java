package com.lanou3g.study;

import org.junit.Test;

import java.io.*;

public class SerializableDemo {
    @Test
    public void output() throws IOException {
        Pet pet = new Pet("雪纳瑞","male");
        FileOutputStream fos = new FileOutputStream("src/pet.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(pet);
        oos.flush();
        oos.close();
    }

    @Test
    public void input() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("src/pet.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Pet pet =(Pet) ois.readObject();
        System.out.println(pet);

    }
}

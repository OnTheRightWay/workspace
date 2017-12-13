package com.lanou3g.homework;

public class liSi {
    public static void main(String[] args) {
        Person liSi = new Person(8060,8061);
        new Thread(new ReceiveServer(liSi)).start();
        new Thread(new SendServer(liSi)).start();
    }
}

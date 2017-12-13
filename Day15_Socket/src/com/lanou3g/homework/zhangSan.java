package com.lanou3g.homework;

public class zhangSan {
    public static void main(String[] args) {
        Person zhangSan = new Person(8061,8060);
        new Thread(new ReceiveServer(zhangSan)).start();
        new Thread(new SendServer(zhangSan)).start();
    }
}

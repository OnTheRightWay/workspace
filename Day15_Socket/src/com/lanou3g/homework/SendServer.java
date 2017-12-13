package com.lanou3g.homework;

import java.io.IOException;

public class SendServer implements Runnable{
    private Person person;

    public SendServer(Person person) {
        this.person = person;
    }
    @Override
    public void run() {
        try {
            person.sendServer();
        } catch (IOException e) {
            System.out.println("连接超时");
        }
    }
}

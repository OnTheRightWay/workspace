package com.lanou3g.homework;

import java.io.IOException;

public class ReceiveServer implements Runnable {
    private Person person;

    public ReceiveServer(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        try {
            person.receiveServer();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

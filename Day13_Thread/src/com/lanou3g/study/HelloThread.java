package com.lanou3g.study;

public class HelloThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10000; i++) {
            System.out.println("hello thread:"+i);
        }
    }
}

package com.lanou3g.homework;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Person {

    private int sendPort;
    private int receivePort;

    public Person(int sendPort, int receivePort) {
        this.sendPort = sendPort;
        this.receivePort = receivePort;
    }

    public void sendServer() throws IOException {
        Scanner input = new Scanner(System.in);
        Socket socket = new Socket("192.168.20.106",sendPort);
        OutputStream os = socket.getOutputStream();
        String word = input.nextLine();
        while (!word.equals("quit")) {
            os.write(word.getBytes());
        }
        os.close();
    }

    public void receiveServer() throws IOException, InterruptedException {
        Thread.sleep(5000);

        ServerSocket ss = new ServerSocket(receivePort);
        Socket accept = ss.accept();
        InputStream is = accept.getInputStream();
        byte[] buff = new byte[1024];
        StringBuffer sb = new StringBuffer();
        int len = 0;
        while ((len = is.read(buff))!=-1) {
            sb.append(new String(buff,0,len));
            System.out.println(sb);
            sb.setLength(0);
        }
        ss.close();
    }
}

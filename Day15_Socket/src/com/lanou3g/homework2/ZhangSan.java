package com.lanou3g.homework2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ZhangSan {
    public static void main(String[] args) throws IOException {
        String send = "";
        Scanner input = new Scanner(System.in);
        Socket socket = new Socket("192.168.20.106",8060);
        OutputStream os = socket.getOutputStream();

        byte[] buff = new byte[1024];

        boolean isEnd =false;
        while (!isEnd){
            if ((send = input.nextLine()).equals("quit")){
                isEnd = true;
            }
            if(send.equals("start")){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ServerSocket ss = null;
                        try {
                            ss = new ServerSocket(8061);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Socket s = null;
                        try {
                            s = ss.accept();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        byte[] buff = new byte[1024];
                        InputStream is = null;
                        try {
                            is = s.getInputStream();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        StringBuffer sb = new StringBuffer();
                        int len = 0;
                        try {
                            while ((len = is.read(buff)) != -1){
                                sb.append(new String(buff,0,len));
                                System.out.println(sb);

                                sb.setLength(0);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            ss.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
            os.write(send.getBytes());
        }
        socket.close();
    }
}

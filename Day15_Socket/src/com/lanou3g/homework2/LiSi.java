package com.lanou3g.homework2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class LiSi {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8060);
        Socket s = ss.accept();
        byte[] buff = new byte[1024];
        InputStream is = s.getInputStream();

        StringBuffer sb = new StringBuffer();
        int len = 0;
        while ((len = is.read(buff)) != -1){

            sb.append(new String(buff,0,len));
            System.out.println(sb);
            if (new String(sb).equals("start")){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Scanner input = new Scanner(System.in);
                        Socket socket = null;
                        try {
                            socket = new Socket("192.168.20.106",8061);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        OutputStream os = null;
                        try {
                            os = socket.getOutputStream();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        String word = null;
                        while (!(word = input.nextLine()).equals("quit")) {
                            try {
                                os.write(word.getBytes());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            os.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
            sb.setLength(0);
        }
        ss.close();
    }
}

package com.lanou3g.tcp.practice;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class LiSi {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        Scanner input = new Scanner(System.in);

        Socket s = ss.accept();
        byte[] buff = new byte[1024];
        InputStream is = s.getInputStream();
        //获得与这个ServerSocket连接的Socket的输出流
        OutputStream os = s.getOutputStream();

        StringBuffer sb = new StringBuffer();
        int len = 0;
        while ((len = is.read(buff)) != -1){

            sb.append(new String(buff,0,len));
            System.out.println(sb);
            //把sb清空
            sb.setLength(0);

            os.write(input.nextLine().getBytes());
        }
        ss.close();
    }
}

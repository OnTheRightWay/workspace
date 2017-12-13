package com.lanou3g.udp;

import com.lanou3g.util.Constants;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class SendMain {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(8096);

        //创建一个地址对象，将ip地址传到构造方法中
        InetAddress address = InetAddress.getByName(Constants.ADDRESS2);

        byte[] buff = new byte[1024];

        buff = new Scanner(System.in).nextLine().getBytes();

        //创建用来存储数据的数据包
        DatagramPacket dp = new DatagramPacket(buff,buff.length,address,8089);

        ds.send(dp);
    }
}

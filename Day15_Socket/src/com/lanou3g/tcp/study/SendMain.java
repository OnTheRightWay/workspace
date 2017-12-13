package com.lanou3g.tcp.study;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SendMain {
    public static void main(String[] args) throws IOException {
        //创建一个socket对象
        //指定目标的ip地址和端口号
        Socket socket = new Socket("192.168.1.151",9999);

        //获得socket对象的输出工具
        //这个东西我们叫做流
        OutputStream os = socket.getOutputStream();

        //调用这个工具的写方法
        //把要传输的内容作为参数传进去
        //参数是一个字节数组
        os.write(("北国风光，千里冰封，万里雪飘。\n" +
                "望长城内外，惟余莽莽；大河上下，顿失滔滔。\n" +
                "山舞银蛇，原驰蜡象，欲与天公试比高。\n" +
                "须晴日，看红装素裹，分外妖娆\n" +
                "江山如此多娇，引无数英雄竞折腰。\n" +
                "惜秦皇汉武，略输文采；唐宗宋祖，稍逊风骚。\n" +
                "一代天骄，成吉思汗，只识弯弓射大雕。\n" +
                "俱往矣，数风流人物，还看今朝。").getBytes());

        //关闭socket
        socket.close();
    }
}

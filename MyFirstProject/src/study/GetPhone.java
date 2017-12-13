package study;

import study.util.Tool;

import java.io.IOException;

public class GetPhone {
    public static String getPhone() throws IOException {

        Tool<Phone> tool = new Tool<>();
        Phone phone = tool.getInstence("http://api.k780.com/?app=phone.get&phone=13800138000&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json", Phone.class);
        return phone.getResult().getArea();
    }
}

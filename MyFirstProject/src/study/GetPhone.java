package study;

import study.util.Tool;

import java.io.IOException;

public class GetPhone {
    public static String getPhone(String phone) throws IOException {

        Tool<Phone> tool = new Tool<>();
        Phone pho = tool.getInstence("http://api.k780.com/?app=phone.get&phone="+phone+"&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json", Phone.class);
        Phone.ResultBean result = pho.getResult();
        return result.getArea();
    }
}

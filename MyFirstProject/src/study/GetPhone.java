package study;

import study.util.Tool;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetPhone {
    public static String getPhone(String phone) throws IOException {

//        Map map =new HashMap();
//        Phone.ResultBean p = new Phone.ResultBean();
//        map.put("result",Phone.ResultBean.class);
//        map.put("result",p);
//        Phone pho = (Phone) Tool.getInstence("http://api.k780.com/?app=phone.get&phone="+phone+"&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json", Phone.class,map);
        Phone pho = (Phone) Tool.getInstence("http://api.k780.com/?app=phone.get&phone="+phone+"&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json", Phone.class,Phone.ResultBean.class);
        Phone.ResultBean result = pho.getResult();
        return result.getAtt();
    }
}

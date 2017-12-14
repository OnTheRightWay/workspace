package study.game;

import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import study.bean.FirstPerson;
import study.constant.Constant;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class FirstRank {
    public static void getFirst() throws IOException, DocumentException {
        URL url = new URL("http://"+ Constant.URLBASE+"/day16/first");
//        URLConnection conn = url.openConnection();
//        InputStream is = conn.getInputStream();
//        byte[] buff = new byte[1024];
//        int len = is.read(buff);
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(url);
        Element root = document.getRootElement();
        System.out.println("第一名："+root.element("nickname").getText()+"\t成绩："+root.element("score").getText());
    }
//    public static void getFirst(String s) throws IOException {
//        URL url = new URL("http://192.168.20.221:8080/day16/first");
//        URLConnection conn = url.openConnection();
//        InputStream is = conn.getInputStream();
//        byte[] buff = new byte[1024];
//        int len = is.read(buff);
//        String ss = new String(buff,0,len);
//        System.out.println(ss);
//        XStream xStream = new XStream();
//        xStream.aliasAttribute("User","nickname");
//        FirstPerson firstPerson = (FirstPerson)xStream.fromXML(ss);
//        System.out.println(firstPerson.getNickname());
////        System.out.println("第一名："+root.element("nickname").getText()+"\t成绩："+root.element("score").getText());
//    }

}

package study.game;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class FirstRank {
    public static void getFirst() throws IOException, DocumentException {
        URL url = new URL("http://192.168.20.221:8080/day16/first");
//        URLConnection conn = url.openConnection();
//        InputStream is = conn.getInputStream();
//        byte[] buff = new byte[1024];
//        int len = is.read(buff);
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(url);
        Element root = document.getRootElement();
        System.out.println("第一名："+root.element("nickname").getText()+"\t成绩："+root.element("score").getText());
    }

}

package homework;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Test {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080/book");
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        byte []b=new byte[1024*1024];
        is.read(b);
        System.out.println(new String(b));
    }
}

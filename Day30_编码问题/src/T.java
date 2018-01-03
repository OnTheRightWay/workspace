import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

public class T {
    @Test
    public void t() throws UnsupportedEncodingException {
        String name = "张三";
        System.out.println(Arrays.toString(name.getBytes("UTF-8")));
        name = URLEncoder.encode(name,"UTF-8");
        System.out.println(name);
        name= URLDecoder.decode(name,"UTF-8");
        System.out.println(name);
    }
}

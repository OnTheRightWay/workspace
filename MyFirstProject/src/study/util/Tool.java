package study.util;

import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Tool {
    public static <T> T getInstence(String url,T t) throws IOException {
        URL u = new URL(url);
        URLConnection conn = u.openConnection();
        InputStream is = conn.getInputStream();
        byte[] buff = new byte[1024];
        int len = 0;
        StringBuffer sb = new StringBuffer();
        while ((len = is.read(buff))!= -1) {
            sb.append(new String(buff, 0, len));
        }
        JSONObject jsonObject = JSONObject.fromObject(sb);
        return (T)JSONObject.toBean(jsonObject,t.getClass());
    }
}

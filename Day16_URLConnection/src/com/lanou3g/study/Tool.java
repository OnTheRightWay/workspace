package com.lanou3g.study;

import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class Tool {
    public static Object getInstence(String url, Class c,Class o) throws IOException {
        URL u = new URL(url);
        URLConnection conn = u.openConnection();
        InputStream is = conn.getInputStream();
        byte[] buff = new byte[1024*1024];
        int len = is.read(buff);
        String result = new String(buff, 0, len);
        Map m = new HashMap();
        m.put("result",o);

        JSONObject jsonObject = JSONObject.fromObject(result);
        if (o==null)
            return JSONObject.toBean(jsonObject,c);
        return JSONObject.toBean(jsonObject,c,m);
    }
}

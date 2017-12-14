package study.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class URLTool {
    public static Object getInstence(String url, Class c,Class o) throws IOException {
        URL u = new URL(url);
        URLConnection conn = u.openConnection();
        InputStream is = conn.getInputStream();
        byte[] buff = new byte[1024];
        int len = 0;
        StringBuffer sb = new StringBuffer();
        while ((len = is.read(buff))!=-1){
            sb.append(new String(buff,0,len));
        }
        Map m = new HashMap();
        m.put("result",o);

        JSONObject jsonObject = JSONObject.fromObject(new String(sb));
//        if (o==null)
//        return JSONObject.toBean(jsonObject,c);
        return JSONObject.toBean(jsonObject,c,m);
    }
    public static Object getInstence(String url, Class c) throws IOException {
        URL u = new URL(url);
        URLConnection conn = u.openConnection();
        InputStream is = conn.getInputStream();
        byte[] buff = new byte[1024];
        int len = 0;
        StringBuffer sb = new StringBuffer();
        while ((len = is.read(buff))!=-1){
            sb.append(new String(buff,0,len));
        }
        JSONArray jsonArray = JSONArray.fromObject(new String(sb));
//        if (o==null)
//        return JSONObject.toBean(jsonObject,c);
        return JSONArray.toArray(jsonArray,c);
    }
}

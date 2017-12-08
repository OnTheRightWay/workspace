package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PPP {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        map.put("名字","张三");
        map.put("年龄","13");
        map.put("性别","男");

        System.out.println("第一种");
        for(String s:map.keySet()){
            System.out.println("key:"+s+"---value:"+map.get(s));
        }

        System.out.println("第二种");
        for (Map.Entry<String,String> m:map.entrySet()){
            System.out.println("key:"+m.getKey()+"---value:"+m.getValue());
        }

        System.out.println("第三种");
        Set set = map.entrySet();
        Iterator<Map.Entry<String,String>> iter = set.iterator();
        while (iter.hasNext()){
            Map.Entry<String,String> m =iter.next();
            System.out.println("key:"+m.getKey()+"---value:"+m.getValue());
        }

        System.out.println("第四种");
        for(String s:map.values()){
            System.out.println("value:"+s);
        }

    }
}

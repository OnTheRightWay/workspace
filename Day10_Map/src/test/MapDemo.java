package test;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(3,"张三");
        map.put(4,"李四");
        map.put(5,"王五");
        map.put(6,"赵六");

        System.out.println("第一种遍历方式");
        for (int i :
                map.keySet()) {
            System.out.println("key:"+i+"---value:"+map.get(i));
        }

        System.out.println("第二种遍历方式");
        for (Map.Entry<Integer, String> m :
                map.entrySet()) {
            System.out.println("key："+m.getKey()+"---value:"+m.getValue());
        }

        System.out.println("第三种遍历方式");
        Iterator<Map.Entry<Integer,String>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<Integer,String> m = iter.next();
            System.out.println("key："+m.getKey()+"---value:"+m.getValue());
        }

        System.out.println("第四种遍历方式");
        for (String s :
                map.values()) {
            System.out.println("values:"+s);
        }

    }
}

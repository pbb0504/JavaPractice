package com.company.hashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        // put方法如果存入一个与之前键值对具有相同键的键值对，那么会覆盖之前的值，put方法会返回覆盖的值
        map.put(1,"1");
        map.put(2,"2");
        map.put(3,"3");
        map.put(4,"4");
        map.put(5,"5");
        System.out.println("contains: "+map.containsKey(1));
        System.out.println("contains: "+map.containsValue("1"));
        System.out.println("to get value: " + map.get(3));
        // 下面两行可以用来判断是否判断一个键或一个值是否存在
        map.put(null,"6");
        map.put(7,null);
        System.out.println(map);
        Collection<String> collections = map.values();
        System.out.println("all values: " + collections);
    }
}

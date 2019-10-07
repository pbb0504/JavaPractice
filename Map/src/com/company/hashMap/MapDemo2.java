package com.company.hashMap;

/*
map集合的两种取出方式：
1.keySet：将map中所有的键存入到Set集合。因为set具备迭代器。
	所有可以迭代方式取出所有的键，再根据Set方法。获取每一个键对应的值

	Map集合的取出原理：将map集合转成set集合，再通过迭代器取出
	返回Set<key>

2.Set<Map.entry<k,v> entrySet:
	将map集合中的映射关系存入到了set集合中，
	而这个关系的数据类型就是：Map.Entry
	
*/
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo2 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("01","01-1");
        map.put("02","02-1");
        map.put("03","03-1");
        map.put("04","04-1");
        map.put("05","05-1");
		// 将Map集合中的映射关系取出，存入到Set集合中
		Set<Map.Entry<String,String>> entrySet = map.entrySet();
		Iterator<Map.Entry<String,String>> it = entrySet.iterator();
		while(it.hasNext()){
			Map.Entry<String,String> me = it.next();
			String key = me.getKey();
			String value = me.getValue();
			System.out.println(key+": "+value);
		}
		/*
        Set<String> set = map.keySet();
//        for(Iterator iterator = set.iterator(); iterator.hasNext();){
//            String value = map.get(iterator.next());
//            System.out.println(iterator.next()+": "+value);
//        }
        for (String key : set) {
            String value = map.get(key);
            System.out.println(key + ": " + value);
        }
		*/
    }
}

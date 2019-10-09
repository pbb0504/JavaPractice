
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map;


class TreeMapTest2 {
	public static void main(String[] args){
		String s = charCount("aaasssddd");
		System.out.println(s);
	}
	
	static String charCount(String str){
		char[] chars = str.toCharArray();
		TreeMap<Character,Integer> tm = new TreeMap<>();
		for(int x=0; x<chars.length; x++){
			Integer value = tm.get(chars[x]);
			if(value == null){
				tm.put(chars[x],1);
			}else{
				value = value + 1;
				tm.put(chars[x],value);
			}
		}
		
		StringBuilder sb = new StringBuilder();		Set<Map.Entry<Character,Integer>> set = tm.entrySet();
		Iterator<Map.Entry<Character,Integer>> it = set.iterator();
		
		while(it.hasNext()){
			Map.Entry<Character,Integer> entry = it.next();
			Character ch = entry.getKey();
			Integer val = entry.getValue();
			sb.append(ch + "(" + val + ")");
		}
		return sb.toString();
	}
}
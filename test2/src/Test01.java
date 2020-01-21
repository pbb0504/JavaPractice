import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        
        for (String s : list) {
            System.out.println("list: " + s);
            if("1".equals(s)){
                list.remove("1");
            }
        }
        System.out.println(list);

        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        Iterator<String> iterator1 = list1.iterator();
        while (iterator1.hasNext()) {
            String next = iterator1.next();
            System.out.println("list1: " + next);
            if ("1".equals(next)) {
                iterator1.remove();
            }
        }
        System.out.println(list1);
    }
}

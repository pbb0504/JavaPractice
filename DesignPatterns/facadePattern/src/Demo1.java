import java.util.Scanner;

/**
 * @author: pbb
 * @date: 2020/10/18 9:47
 */
public class Demo1 {
    public static void main(String[] args) {
        String res;
        String s = null;
        final String s1 = "1";
        final String s2 = "2";
        Scanner in = new Scanner(System.in);
        if(in.hasNext()){
            s = in.next();
        }
        in.close();
        res = switch (s){
            case s1 -> "2";
            case s2 -> "3";
            default -> throw new IllegalStateException("Unexpected value: " + s);
        };
        System.out.println(res);
    }
}

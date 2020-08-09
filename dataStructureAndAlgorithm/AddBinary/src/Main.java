import java.util.Random;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().addBinary("111","111"));
    }

    public String addBinary(String a, String b) {
        String res;
        StringBuilder sb = new StringBuilder();
        if (a.length() == 0) return a;
        if (b.length() == 0) return b;
        int c = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0) c += a.charAt(i--) - '0';
            if (j >= 0) c += b.charAt(j--) - '0';
            sb.append(c % 2);
            c >>= 1; //  c=c/2; 将二进制形式向右位移一位
        }
        res = sb.reverse().toString();
        return c > 0 ? '1' + res : res; // 在res前面加上‘1’ , 检查是否进位
    }
}

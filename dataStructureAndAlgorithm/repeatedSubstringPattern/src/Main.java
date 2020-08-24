/**
 * @author: pbb
 * @date: 2020/8/24 19:48
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("a"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        // 重复多次，一次不算
        // 一个元字符串
        // 一个长度的不符合，不代表两个长度的不符合
        int index;
        for (int i = 1; i < s.length(); i++) {
            if (s.length() % i == 0) {
                index = 0;
                String sub = s.substring(0, i);
                for (int j = 1; j <= s.length() / i; j++) {
                    if (!s.substring(index, index + i).equals(sub)) {
                        break;
                    }
                    index += i;
                    if (j == (s.length() / i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

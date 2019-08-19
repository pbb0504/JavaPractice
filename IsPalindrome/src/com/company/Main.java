package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(new Main().isPalindrome("0P"));
    }

    private boolean isPalindrome(String s) {
        if (s.equals("")) return true;
        s = s.toLowerCase();// 全部转为小写
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') sb.append(c);
        }
        int j = sb.length() - 1;
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(j))
                return false;
            j--;
        }
        return true;
    }
}

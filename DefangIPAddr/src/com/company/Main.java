package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    public String defangIPaddr(String address) {
        char[] chars = address.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c == '.')
                sb.append("[.]");
            else
                sb.append(c);
        }
        return sb.toString();
    }
}

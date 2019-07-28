package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(new Main().romanToInt("MMMM"));
    }
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if(i<chars.length-1){
                if (chars[i] == 'I' && chars[i + 1] == 'V') {
                    result -= 1;
                    i++;
                } else if (chars[i] == 'I' && chars[i + 1] == 'X') {
                    result -= 1;
                    i++;
                } else if (chars[i] == 'X' && chars[i + 1] == 'L') {
                    result -= 10;
                    i++;
                } else if (chars[i] == 'X' && chars[i + 1] == 'C') {
                    result -= 10;
                    i++;
                } else if (chars[i] == 'C' && chars[i + 1] == 'D') {
                    result -= 100;
                    i++;
                } else if (chars[i] == 'C' && chars[i + 1] == 'M') {
                    result -= 100;
                    i++;
                }
                switch (s.charAt(i)) {
                    case 'I':
                        result += 1;
                        break;
                    case 'V':
                        result += 5;
                        break;
                    case 'X':
                        result += 10;
                        break;
                    case 'L':
                        result += 50;
                        break;
                    case 'C':
                        result += 100;
                        break;
                    case 'D':
                        result += 500;
                        break;
                    case 'M':
                        result += 1000;
                        break;
                }
            }else
                switch (s.charAt(i)) {
                    case 'I':
                        result += 1;
                        break;
                    case 'V':
                        result += 5;
                        break;
                    case 'X':
                        result += 10;
                        break;
                    case 'L':
                        result += 50;
                        break;
                    case 'C':
                        result += 100;
                        break;
                    case 'D':
                        result += 500;
                        break;
                    case 'M':
                        result += 1000;
                        break;
            }
        }
        return result<4000?result:0;
    }
}

package com.company;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
	// write your code here
        long start=System.currentTimeMillis();
        System.out.println(reverse(-2147483648));
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
    static int reverse(int x){
        while(x!=0){
            if (x>0&&x<=Integer.MAX_VALUE){
                String s=String.valueOf(x);
                char[] chars=s.toCharArray();
                Stack<Character> st=new Stack<>();
                for(char m : chars){
                    st.push(m);
                }
                for(int i=0;i<st.size();i++){
                    char cc=st.pop();
                    if (cc!='0'){
                        st.push(cc);
                        break;
                    }
                }
                char[] chars1=new char[st.size()];
                for(int k=0;k<chars1.length;k++){
                    chars1[k]=st.pop();
                }
                try{
                    return Integer.parseInt(String.valueOf(chars1));
                }catch(Exception e){
                    // 反转过后会出现超出范围的数字直接返回0
                    return 0;
                }
            }else if(x>=Integer.MIN_VALUE&&x<0){
                String s=String.valueOf(x);
                s=s.substring(1);
                char[] chars=s.toCharArray();
                Stack<Character> st=new Stack<>();
                for(char m : chars){
                    st.push(m);
                }
                for(int i=0;i<st.size();i++){
                    char cc=st.pop();
                    if (cc!='0'){
                        st.push(cc);
                        break;
                    }
                }
                char[] chars1=new char[st.size()];
                for(int k=0;k<chars1.length;k++){
                    chars1[k]=st.pop();
                }
                try{
                    return Integer.parseInt("-"+String.valueOf(chars1));
                }catch(Exception e){
                    // 反转过后会出现超出范围的数字直接返回0
                    return 0;
                }
            }
        }
        return 0;
    }
}
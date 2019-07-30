package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(new Main().numJewelsInStones("Aa","Askaa"));
    }
    public int numJewelsInStones(String J,String S){
        int res=0;
        for(int i=0;i<J.length();i++){
            for(int j=0;j<S.length();j++){
                if(J.charAt(i)==S.charAt(j)) res++;
            }
        }
        return res;
    }
}

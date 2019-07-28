package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] a={1,2,3};

    }
    public int[] plusOne(int[] digits) {
        if(digits.length==1&&digits[0]==9) return new int[] {1,0};
        int[] results=new int[digits.length+1];
        if(digits[digits.length-1]<'9') {
            digits[digits.length - 1]++;
            return digits;
        }
        else{
            digits[digits.length-1]=0;
            results[results.length-1]=0;
            for(int i=digits.length-2;i>=0;i--){
                if(digits[i]<9){
                    digits[i]++;
                    return digits;
                }else if(digits[i]==9){
                    digits[i]=0;
                    results[i+1]=0;
                    if(i==0) results[0]=1;
                }
            }
        }
        return results;
    }
}

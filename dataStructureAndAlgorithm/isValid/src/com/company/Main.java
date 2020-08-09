package com.company;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(new Main().isValid("(]"));
    }
    public boolean isValid(String s) {
        char[] chars=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        if(s.length()==0) return true;
        for(char c : chars){
            if(c=='('||c=='{'||c=='[')
                stack.push(c);
            try{
                switch(c){
                    case ')': if(stack.peek()=='(') stack.pop(); else return false; break;
                    case '}': if(stack.peek()=='{') stack.pop(); else return false; break;
                    case ']': if(stack.peek()=='[') stack.pop(); else return false; break;
                }
            }catch (EmptyStackException e){
                return false;
            }
        }
        if(stack.empty()) return true;
        return false;
    }
}

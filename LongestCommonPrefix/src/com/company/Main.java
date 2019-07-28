package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String[] strs = {"cb", "cb", "cab"};
        System.out.println(new Main().longestCommonPrefix(strs));
    }

    private String longestCommonPrefix(String[] strs) {

        // 解法1
        //int minLength=0;
        //String now;
        //String last="";
        //List<String> st=new ArrayList<>();
        //// 如果为空，返回""
        //if(strs.length==0) return "";
        //
        //// 计算最小长度
        //for(int i=0;i<strs.length;i++){
        //    if(i<strs.length-1&&(strs[i].equals("")||strs[i+1].equals("")))
        //        return "";
        //    else if(strs[i].equals("")&&i==strs.length-1) return "";
        //    else if(strs.length==1) return strs[0];
        //}
        //minLength=Math.min(strs[0].length(),strs[1].length());
        //for(int i=2;i<strs.length;i++){
        //    minLength=Math.min(minLength,strs[i].length());
        //}
        //// 进行前缀提取
        //for(int k=0;k<minLength;k++){
        //    st.clear();
        //    for(int j=0;j<strs.length;j++){
        //        st.add(strs[j].substring(0,k+1));
        //    }
        //    now=st.get(0);
        //
        //    for(int i=0;i<st.size();i++){
        //        if(!st.get(i).equals(now))
        //            return last;
        //        }
        //    last=now;
        //}
        //
        //return last;
        //}

        // 解法2
        if(strs.length==0) return "";
        if(strs.length==1) return strs[0];
        String prefix=strs[0];
        int length=prefix.length();
        for(int i=0;i<strs.length;i++){
            while(length>strs[i].length() || !prefix.equals(strs[i].substring(0,length))){
                prefix=prefix.substring(0,length-1);
                length-=1;
                if(length==0)
                    return "";
            }
        }
        return prefix;
    }

}


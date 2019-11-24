package com.company.annotation;

import java.util.Date;

@SuppressWarnings("all")
public class AnnoDemo2 {
    @Override
    public String toString(){
        return super.toString();
    }

    @Deprecated
    public void show(){

    }

    public void show2(){

    }

    public void demo(){
        show();
        Date date = new Date();
    }
}

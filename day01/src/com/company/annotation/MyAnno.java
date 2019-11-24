package com.company.annotation;

@SuppressWarnings("all")
public @interface MyAnno {

    int value();

    Person p1();

    MyAnno2 anno();

    String[] arrs();
    /*int age();
    String name();
    int att() default 3;*/
    /*String show2();

    Person p1();

    MyAnno2 anno();*/
}

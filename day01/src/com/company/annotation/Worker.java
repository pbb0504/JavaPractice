package com.company.annotation;

@MyAnno(value = 12, p1 = Person.P1, anno = @MyAnno2, arrs = {"a","b"})
@MyAnno3
public class Worker {
    // @MyAnno3
    public void show(){

    }
}

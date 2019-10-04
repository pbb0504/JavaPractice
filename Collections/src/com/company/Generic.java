package com.company;

public class Generic {
    public static void main(String[] args) {
//        Tool t = new Tool();
//        t.setO(new Worker());
//        Worker w = (Worker)t.getO();
        Utils<Worker> utils = new Utils<>();
        utils.setG(new Worker("test"));
        Worker worker = utils.getG();
        System.out.println(worker.getName());
    }
}

class Worker{
    private int age;
    private String name;

    public Worker(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
}

class Student{
    private int age;
    private String name;
}

class Tool{
    private Object o;

    public Tool() {

    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }
}

// 泛型类
class Utils<G>{
    private G g;

    public G getG() {
        return g;
    }

    public void setG(G g) {
        this.g = g;
    }

}
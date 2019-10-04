package com.company;

import java.util.Comparator;
import java.util.TreeSet;

public class Generic6 {
    public static void main(String[] args) {
        // 用子类指向父类
        TreeSet<Two> twos = new TreeSet<>(new Comp2());
        twos.add(new Two("1"));
        twos.add(new Two("2"));
        twos.add(new Two("3"));
        twos.add(new Two("4"));

        for (Two two : twos) {
            System.out.println(two);
        }
    }
}

//class Comp implements Comparator<Two> {
//    @Override
//    public int compare(Two t1, Two t2) {
//        return t1.getName().compareTo(t2.getName());
//    }
//}

// 明明是<? super E>，为什么继承于One的Two可以使用这个排序类
// 多态，父类实现的接口，子类也可以使用
class Comp2 implements Comparator<One> {
    @Override
    public int compare(One t1, One t2) {
        return t1.getName().compareTo(t2.getName());
    }
}

class One {
    private String name;

    One(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    public String toString() {
        return "person: " + name;
    }
}

class Two extends One {
    // 这里如果用Two类中的name，就会出现空指针异常
    // 而且已经继承One类，所以不用重新定义name，亦不用重新写getName方法
    // super后，传进来的参数会跑到One中的方法，但是Comp类需要使用Two的参数
    // 找不到参数？
    Two(String name) {
        super(name);
    }
}
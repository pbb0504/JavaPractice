package com.company.list;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("01");
        linkedList.addFirst("02");
        linkedList.addFirst("03");
        linkedList.addFirst("04");
        System.out.println(linkedList);
        System.out.println("get first: " + linkedList.getFirst());
        System.out.println("get last: " + linkedList.getLast());
        linkedList.removeFirst();
        System.out.println("remove first: " + linkedList);
        linkedList.removeLast();
        System.out.println("remove last: " + linkedList);
        linkedList.clear();
        System.out.println("-----------------------------------------");
        MyQueue myQueue = new MyQueue(linkedList);
        myQueue.add("1");
        myQueue.add("2");
        myQueue.add("3");
        System.out.println("after add: "+linkedList);
        System.out.println("get: "+myQueue.get());
        System.out.println("is it empty: "+myQueue.isEmpty());
    }
}

class MyQueue {
    private LinkedList linkedList;

    MyQueue(LinkedList linkedList) {
        this.linkedList = linkedList;
    }

    void add(Object object) {
        linkedList.add(object);
    }

    Object get() {
        return linkedList.getFirst();
    }

    boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
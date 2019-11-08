package com.company;


import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
       ListNode l1 = new ListNode(4);
       l1.addAtLast(l1,0);
       l1.addAtLast(l1,4);
       l1.addAtLast(l1,4);

       ListNode l2 = new ListNode(4);
       l2.addAtLast(l2,0);
       l2.addAtLast(l2,4);
       l2.addAtLast(l2,4);
        ListNode l3 = addTwoNumbers(l1, l2);
        while(l3.next != null){
            System.out.println(l3.val);
        }
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        // 链表中数字倒序存储

        return l2;
    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    void addAtLast(ListNode listNode, int object){
        ListNode tail = new ListNode(object);
        ListNode current = listNode;
        while(current.next != null){
            current = current.next;
        }
        current.next = tail;
    }
}
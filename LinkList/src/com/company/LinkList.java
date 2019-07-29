package com.company;

public class LinkList {
    private int size;
    private Node head;

    public LinkList() {
        size = 0;
        head = null;
    }

    private class Node {
        private Object data;
        private Node next;

        public Node(Object obj) {
            this.data = obj;
        }
    }

    // 在表头添加元素
    public Object addHead(Object obj) {
        Node newNode = new Node(obj);
        if (size == 0) head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        return obj;
    }

    // 在链表头删除元素
    public Object deleteHead() {
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    //  查找指定元素，找到了返回指定元素，找不到返回null
    public Object find(Object obj) {
        Node current = head;
        int size2 = size;
        while (size2 > 0) {
            if (obj.equals(current.data))
                return obj;
            else
                current = current.next;
            size2--;
        }
        return null;
    }


    // 查找指定Node，找到了返回指定结点，找不到返回null
    public Node find(Node node) {
        Node current = head;
        int size2 = size;
        while (size2 > 0) {
            if (node == current) {
                return node;
            } else {
                current = current.next;
            }
            size2--;
        }
        return null;
    }

    // 删除指定元素，并返回该元素data，找不到返回null
    public Object delete(Object obj) {
        if (size == 0) return null;
        Node previous = head;
        Node current = head;
        while (current.data != obj) {
            if (current.next == null)
                return "无该元素";
            else {
                previous = current;
                current = current.next;
            }
        }
        // 看删除的结点是否为第一个，做出不同的删除动作
        if (current == previous) {
            Object result = head.data;
            head = current.next;
            size--;
            return result;
        } else {
            Object result = current.data;
            previous.next = current.next;
            size--;
            return result;
        }
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return (size == 0);
    }

    // 显示链表信息
    public void display() {
        if (size > 0) {
            Node node = head;
            int size2 = size;
            if (size2 == 1) {
                System.out.println("[" + node.data + "]");
            }
            while (size2 > 0) {
                if (size2 == size) {
                    System.out.print("[" + node.data + "->");
                } else if (size2 == 1) {
                    System.out.println(node.data + "]");
                } else
                    System.out.print(node.data + "->");
                node = node.next;
                size2--;
            }
        } else {
            System.out.println("[]");
        }
    }
}

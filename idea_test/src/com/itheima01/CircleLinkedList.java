package com.itheima01;

public class CircleLinkedList {
    private Node head = new Node();

    public CircleLinkedList() {
        this.head.setData(1);
        head.next = head;
    }

    // num表示这个队伍有多少人
    public void addLoop(int num) {
        Node nodeNext = head;
        if (num < 2) {
            System.out.println("队伍中默认有一个人，请添加大于等于2的数");
            return;
        }
        for (int i = 2; i <= num; i++) {
            nodeNext.next = new Node(i);
            nodeNext = nodeNext.next;
        }
        nodeNext.next = head;
    }

    public void Josepfu(int m) {
        if (m < 1) {
            System.out.println("报的数必须为正数");
            return;
        }
        int k = 1;
        Node node = head;
        System.out.print("出队顺序：");
        while (node.next != node) {
            if (k == m - 1) {
                System.out.print(node.next.getData() + " -> ");
                node.next = node.next.next;
                k = 0;
            }
            node = node.next;
            k++;
        }
        System.out.print(node.getData());
    }

    public void display() {
        Node target = head;
        System.out.print("单链表为：");
        System.out.print(target.getData() + " ");
        while ((target = target.next) != head) {
            System.out.print(target.getData() + " ");
        }
        System.out.println();
    }
}

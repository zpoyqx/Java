package com.itheima02;

public class DoubleLinkedList {
    private Node head = new Node(null);
    private int length = 0;

    private Node searchTarget(int index) {
        if (index < 0 || index > length) {
            System.out.println("索引位置[" + index + "]超出索引范围");
            return null;
        }
        else if (index == 0) {
            return head;
        }
        else {
            Node target = head.next;
            for (int i = 0; i < index - 1; i++) {
                target = target.next;
            }
            return target;
        }
    }

    public void add(String data) {
        Node node = new Node(data);
        Node target = searchTarget(length);
        target.next = node;
        node.pre = target;
        node.next = null;
        length++;
    }

    public void add(int index, String data) {
        Node node = new Node(data);
        Node target = searchTarget(index);
        if (target == null) {return;}
        node.next = target.next;
        node.pre = target;
        if (index != length) { target.next.pre = node; }
        target.next = node;
        length++;
    }

    public void delete(int index) {
        if (index < 0 || index >= length) {
            System.out.println("索引位置[" + index + "]超出索引范围");
            return;
        }
        Node target = searchTarget(index).next;
        length--;

        target.pre.next = target.next;
        // 当删除的是最后一个节点时，target.next = null
        if (index != length) { target.next.pre = target.pre;; }
    }

    public void display() {
        Node target = head;
        System.out.print("单链表为：");
        while ((target = target.next) != null) {
            System.out.print(target.getData() + " ");
        }
        System.out.println();
    }
}

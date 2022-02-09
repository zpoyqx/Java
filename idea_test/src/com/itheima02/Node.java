package com.itheima02;

public class Node {
    private String data;
    public Node pre;
    public Node next;

    public Node(String data) {
        this.data = data;
        pre = next = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

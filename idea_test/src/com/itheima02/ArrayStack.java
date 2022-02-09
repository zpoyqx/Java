package com.itheima02;

public class ArrayStack {
    private final int maxSize;
    private int top = -1;
    private final int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isEmpty() {return top == -1;}

    public boolean isFull() {return top == maxSize - 1;}

    public int length() {return top + 1;}

    public int peek() {
        if (isEmpty())
            throw new RuntimeException("栈已空，无法弹出数据");
        else
            return stack[top];
    }

    public void push(int data) {
        if (isFull())
            System.out.println("栈已满，无法插入数据");
        else
            stack[++top] = data;
    }

    public int pop() {
        if (isEmpty())
            throw new RuntimeException("栈已空，无法弹出数据");
        else
            return stack[top--];
    }

    public void display() {
        System.out.print("栈中元素为：");
        for (int i = 0; i <= top; i++)
            System.out.print(stack[i]+" ");
        System.out.println();
    }

    public void displayChar() {
        System.out.print("栈中元素为：");
        for (int i = 0; i <= top; i++)
            System.out.print((char)stack[i]+" ");
        System.out.println();
    }
}

package com.itheima02;

import java.util.Stack;

public class Study {
    public static void main(String[] args) {
        Calculator c = new Calculator();
//        c.cal("3 4 + 5 * 6 -");
//        c.cal("- 6 * 5 + 3 4");

        System.out.println(c.cal("1+((2+3)*4)-12"));
    }
}

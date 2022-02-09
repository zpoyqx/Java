package com.itheima02;

import java.util.Stack;

public class Calculator {

    private int operator(int x, int y, String sign) {
//        System.out.println(y + sign + x);
        return switch (sign) {
            case "+" -> y + x;
            // 先出栈的为被减数或被除数
            case "-" -> y - x;
            case "*" -> y * x;
            case "/" -> y / x;
            default -> throw new RuntimeException("符号错误！");
        };
    }

    private int getPriority(char c) {
        return switch (c) {
            case '+', '-' -> 0;
            case '*', '/' -> 1;
            default -> throw new RuntimeException("符号错误！");
        };
    }
    // 获得逆序后缀表达式
    public String polandNotation(String expression) {
        Stack<String> numStack = new Stack<>();
        Stack<Character> signStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c >= '0' && c <= '9') {
                int num = 0;
                // 读取大于等于10的整数
                while (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                    num = num * 10 + Integer.parseInt(String.valueOf(expression.charAt(i)));
                    i++;
                    if (i == expression.length())
                        break;
                }
                if (i != expression.length()) { i--; }
                numStack.push(String.valueOf(num));
            }
            else if (c == ')') {
                char sign;
                while ((sign = signStack.pop()) != '(')
                    numStack.push(String.valueOf(sign));
            }
            // 短路逻辑
            // 注意判断顺序，比如isEmpty()判断应放在peek()前面
            else if (c == '(' || signStack.isEmpty() || signStack.peek() == '(' || getPriority(c) > getPriority(signStack.peek()))
                signStack.push(c);
            else if (getPriority(c) <= getPriority(signStack.peek())) {
                while (getPriority(c) <= getPriority(signStack.peek())) {
                    numStack.push(String.valueOf(signStack.pop()));
                    if (signStack.isEmpty() || signStack.peek() == '(' || getPriority(c) > getPriority(signStack.peek())) {
                        signStack.push(c);
                        break;
                    }
                }
            }
            else {
                throw new RuntimeException("存在非法符号["+ c +"]！");
            }
        }

        while (!signStack.isEmpty())
            numStack.push(String.valueOf(signStack.pop()));
        while (!numStack.isEmpty()) {
            sb.append(numStack.pop()).append(" ");
        }
        // 由于可能存在大于等于10的整数，所以不能直接逆序输出
        return sb.toString();
    }

    // 获得正序后缀表达式
    public String getPolandNotation(String expression) {
        String[] str  = polandNotation(expression).split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]).append(" ");
        }
        return sb.toString();
    }

    // 使用逆序后缀表达式进行计算
    public int cal(String expression) {
        String[] str  = polandNotation(expression).split(" ");
        Stack<Integer> stack = new Stack<>();
        // 在这里逆序访问
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i].charAt(0) >= '0' && str[i].charAt(0) <= '9')
                stack.push(Integer.parseInt(str[i]));
            else
                stack.push(operator(stack.pop(),stack.pop(),str[i]));
        }
        return stack.pop();
    }
}

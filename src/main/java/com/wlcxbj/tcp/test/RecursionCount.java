package com.wlcxbj.tcp.test;

public class RecursionCount {
    public static void main(String[] args) {
        System.out.println(recursion(100));
    }
    private static int recursion(int top){
        if (top < 0)
            return 0;
        if (top == 1)
            return 1;
        return recursion(top - 1) + top;
    }
}

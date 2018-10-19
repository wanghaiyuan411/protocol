package com.wlcxbj.tcp.test.TestStaticFinally;

public class B {
    public static final int III = 1;
    public int age;
    static {
        System.out.println("staic B");
    }

    public B() {
        System.out.println("constructor B");
    }
    public void print1(){
        System.out.println("This is non static method");
    }
    public static void print2(){
        System.out.println("This is static method");
    }
}

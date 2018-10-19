package com.wlcxbj.tcp.test.TestStaticFinally;

public class Client {
    public static void main(String[] args) {
        //A a = new SubA();
        B b = new B();
        b.age = 2;
        b.print1();
        B.print2();
        System.out.println("1:"+b.III);
        //b.III = 2;
        B b1 = new B();
        System.out.println("2:"+b.III);
        //b.III = 3;
        System.out.println("3:"+b.III);
    }
}

package com.wlcxbj.tcp.test.TestStaticFinally;

public class SubA extends A {
    static {
        System.out.println("static SubA");
    }

    public SubA() {
        System.out.println("Constructor subA");
    }
}

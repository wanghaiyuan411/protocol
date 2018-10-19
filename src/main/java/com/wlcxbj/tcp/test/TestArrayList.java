package com.wlcxbj.tcp.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args) {
        /*//A a = new A("haiyuan");
        List<String> list = new LinkedList<>();
        String a = "haiyuan";
        list.add(a);
        System.out.println(a);
        testList(list);
        System.out.println(a);*/








        /*ArrayList<String> a = new ArrayList<>();
        ArrayList b = new ArrayList();
        Class c1 = a.getClass();
        Class c2 = b.getClass();
        System.out.println(c1 == c2); //true*/


        ArrayList<String> a = new ArrayList<>();
        a.add("CSDN_SEU_Cavin");
        Class c = a.getClass();
        try{
            Method method = c.getMethod("add",Object.class);
            method.invoke(a,(int)100);
            System.out.println(a);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private static class A {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public A(String name) {
            this.name = name;
        }
    }
    static void testList(List list){
        String o = (String)list.get(0);
        o = "changed";
    }

}

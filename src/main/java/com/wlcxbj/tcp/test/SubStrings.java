/*
package com.wlcxbj.tcp.test;

import java.util.*;

public class SubStrings {
    public static void main(String args[]){
        sub1("1234567");
    }
    static Set<String> sub1(String s){
        ThreadLocal<String> resource = new ThreadLocal<>();
        resource.set("111");
        Set<String> result = new HashSet();
        List<String> snew = new ArrayList<>();
        result.add(s);
        snew.add(s);
        while (snew.size() > 0 && snew.get(0).length() > 1){
            snew = subString(result, snew);
        }
        System.out.println(result.toString());

        new Thread(() -> System.out.println("string in threadLocal = " + resource.get())).start();

        return result;
    }

    public static List<String> subString(Set<String> result ,final List<String> old){
        List<String> news = new ArrayList<>();
        for (String ss : old){
            String sFirst = ss.substring(0, ss.length()-1);
            String sLast = ss.substring(1, ss.length());
            result.add(sFirst);
            result.add(sLast);
            news.add(sFirst);
            news.add(sLast);
        }



        return news;
    }
}
*/

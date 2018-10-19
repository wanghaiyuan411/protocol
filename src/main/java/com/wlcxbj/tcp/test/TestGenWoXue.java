package com.wlcxbj.tcp.test;

import java.util.*;

public class TestGenWoXue {
    public static void main(String[] args) {
        A a0 = new A("a", 0);
        A a1 = new A("a", 1);
        A a2 = new A("a", 2);
        A a3 = new A("a", 3);
        A a4 = new A("a", 4);
        A b3 = new A("b", 3);
        A b4 = new A("b", 4);
        A b5 = new A("b", 5);
        A b6 = new A("b", 6);
        A c0 = new A("c", 0);
        A c5 = new A("c", 5);
        A c6 = new A("c", 6);
        A d4 = new A("d", 4);
        A d5 = new A("d", 5);
        A d6 = new A("d", 6);
        A d7 = new A("d", 7);

        A e5 = new A("e", 5);
        A e6 = new A("e", 6);
        A e7 = new A("e", 7);
        List<A> list = new ArrayList<A>();
        list.add(a0);list.add(a1);list.add(a2);list.add(a3);list.add(a4);list.add(b3);list.add(b4);list.add(b5);list.add(b6);
        list.add(c0);list.add(c5);list.add(c6);list.add(d4);list.add(d5);list.add(d6);list.add(d7);list.add(e5);list.add(e6);list.add(e7);
        getList(list);
    }
    private static class A{
        String name;
        int value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public A(String name, int value) {
            this.name = name;
            this.value = value;
        }

        @Override
        public int hashCode() {
            return value;
        }
    }
    private static List<String> getList(List<A> list){
        List<String> result = new ArrayList<String>();
        Map<String, Set<Integer>> map = new HashMap<String, Set<Integer>>();
        for (A a:list){
            String key = a.getName();
            if (map.containsKey(key)){
                Set<Integer> set = map.get(key);
                set.add(new Integer(a.getValue()));
            }
            else {
                Set<Integer> set = new HashSet<Integer>();
                set.add(new Integer(a.getValue()));
                map.put(a.getName(), set);
            }
        }
        String key;
        while ((key = getkey(map)) != null){
            result.add(key);
        }
        System.out.println(result);
        return result;
    }

    private static String getkey(Map<String, Set<Integer>> map){
        String key = "";
        Set<Integer> set = new HashSet<Integer>();
        Set<String> stringSet = map.keySet();
        int size = 0;
        for (String s : stringSet){
            if (map.get(s).size() > size){
                size = map.get(s).size();
                key = s;
                set = map.get(key);
            }
        }
        if (size == 0){
            return null;
        }
        map.remove(key);
        stringSet.remove(key);
        for (String s : stringSet){
            Set<Integer> newSet = map.get(s);
            for (Integer i : set){
                if (newSet.contains(i)){
                    newSet.remove(i);
                }
            }
        }
        return key;
    }

}

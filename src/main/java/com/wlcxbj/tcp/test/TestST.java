package com.wlcxbj.tcp.test;

public class TestST {
    public static void main(String[] args) {
        String s = "ace";
        String t = "radfgcfdfsety";
        isChildString(s, t);
    }
    static boolean isChildString(String s, String t){
        boolean result = true;
        char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            String s1 = String.valueOf(chars[i]);
            if (!t.contains(s1)){
                result = false;
                break;
            }
            start = t.indexOf(s1, start);
            /*int index = t.indexOf(s1);
            t = t.substring(index + 1, t.length());*/
        }
        System.out.println(result);
        return result;
    }

}


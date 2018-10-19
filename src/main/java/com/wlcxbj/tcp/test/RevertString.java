package com.wlcxbj.tcp.test;

public class RevertString {
    public static void main(String[] args) {
        String s = "abcdef";
        revert(s);
    }
    private static String revert(String s){
        char[] cs = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = cs.length - 1; i >= 0 ; i--) {
            sb.append(String.valueOf(cs[i]));
        }
        System.out.println(sb);
        return sb.toString();
    }

}

package com.wlcxbj.tcp.test;

public class ThreeRadicalValue {
    public static void main(String[] args) {
        try {
            getThreeRadicalvalue(125);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int getThreeRadicalvalue(int x) throws Exception {
        int n = 0;
        for (int i =x;i > 0;--i){
            if(i * i * i > x){
                continue;
            }
            if (i * i * i < x){
                throw new Exception("x is not clean devide into three ");
            }
            n = i;
            break;

        }
        System.out.println(x + "开三次根号 = " + n);
        return n;
    }
}

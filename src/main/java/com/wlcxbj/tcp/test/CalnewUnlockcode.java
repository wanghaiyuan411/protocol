package com.wlcxbj.tcp.test;

import java.util.Arrays;

public class CalnewUnlockcode {
    public static void main(String[] args) {
        int[] pass = new int[4];
        int body7 = 152480;
        String bo = Integer.toBinaryString(body7);
        for (int j = 0,i = 1;j < 4;j++, i = i + 3) {
            String c = bo.substring(i, i + 3);
            switch (c){
                case "001":pass[j] = 1;
                    break;
                case "010":pass[j] = 2;
                    break;
                case "011":pass[j] = 3;
                    break;
                case "100":pass[j] = 4;
                    break;
            }
        }

        System.out.println(Arrays.toString(pass));

    }

}

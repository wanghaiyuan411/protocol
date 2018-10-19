/*
package com.wlcxbj.tcp.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OpsiteValues {
    public static void main(String[] args){
        int[] a = new int[]{1, -9, 10,9,-1,4};
        System.out.println("before sort "+Arrays.toString(a));
        findOpsiteArrays(a);
    }
    public static Set<int[]> findOpsiteArrays(int[] arrays){
        Set<int[]> result = new HashSet<>();
        for (int i = 0; i < arrays.length - 1; i++) {
            int a = arrays[i];
            for (int j = i + 1; j < arrays.length; j++ ){
                int b = arrays[j];
                int[] re;
                if (a + b == 0){
                    re = new int[]{a, b};
                    result.add(re);
                }
            }
        }
        for (int[] a : result){
            System.out.println(Arrays.toString(a));
        }

        return  result;
    }
}
*/

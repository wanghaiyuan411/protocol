package com.wlcxbj.tcp.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTimstamp {
    public static void main(String[] args) {
        long time = 1536422724;
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(simpleDateFormat.format(date));
    }

}

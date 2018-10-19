package com.wlcxbj.tcp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static String nowString(){
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
        return simpleDateFormat.format(now);
    }

    public static Date string2Date(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
        return simpleDateFormat.parse(date);
    }
    public static void main(String[] args){
        System.out.println(nowString());
    }
}

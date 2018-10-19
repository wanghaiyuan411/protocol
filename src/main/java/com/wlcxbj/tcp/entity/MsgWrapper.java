package com.wlcxbj.tcp.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MsgWrapper {
    private String date; //2015-03-24 10:00:00
    private String Ttype; //1
    private String version; //V1.0.0
    private String serilId; //1600890000
    private String msgId; //23
    private String msgType; // T3
    private String[] body; //
}

package com.wlcxbj.tcp.entity;

import lombok.Data;
import java.util.Date;

@Data
public class T1Entity {
    private Date date; //2015-03-24 10:00:00
    private String Ttype; //1
    private String version; //V1.0.0
    private String serilId; //1600890000
    private String msgId; //23
    private String msgType; // T1
    //body
    private String ICCID;
    private String MAC;
    private String blueVersion;
    private String IMSI;
    private String IMEI;
    private String modelVersion;
    private String reloginReason;
}

package com.wlcxbj.tcp.entity;

import lombok.Data;
import java.util.Date;


@Data
public class T3Entity implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private Date date; //2015-03-24 10:00:00
    private String ttype; //1
    private String version; //V1.0.0
    private String serilId; //1600890000
    private String msgId; //23
    private String msgType; // T1
    //body
    private int positioningStatusSpid;
    private String lng;
    private String lat;
    private String speed;
    private String direct;
    private int lockerStatusSpid;
    private String unlockCode;

    private Integer mcc;
    private Integer mnc;
    private Integer lac;
    private Integer cellid;
    private Integer bsss;
    private String additionalBaseStation1;
    private String additionalBaseStation2;
    private String additionalBaseStation3;
    private String additionalBaseStation4;
    private String additionalBaseStation5;

    private int availableSatellites;
    private String signalstrength;
    private String batteryLevel;

    private String batteryVoltage;//电池电压

    private String pid1;//蓝牙桩编号
    private String pid2;//蓝牙桩编号
    private String pid3;//蓝牙桩编号
    private String orderId;//订单序列号
    private String sceneCode;//场景代码
    private String motorEletricity;//马达驱动电流毫安
    private Date createdTime;
}

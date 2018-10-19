package com.wlcxbj.tcp.entity;
// Generated 2017-2-13 18:03:18 by Hibernate Tools 3.5.0.Final

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * T3Log generated by hbm2java
 */
@Entity
@Table(name = "t3_log")
public class T3Log implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private String tid;
    private String ip;
    private Integer ttype;
    private String tversion;
    private String datagramId;
    private Date datagramTime;
    private String unlockCode;
    private String simno;
    private String lng;
    private String lat;
    private String speed;
    private String direct;
    private int lockerStatusSpid;
    private int positioningStatusSpid;
    private long gpstime;
    private int availableSatellites;
    private String signalstrength;
    private String batteryLevel;
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
    private String batteryVoltage;//电池电压
    private String pid;//蓝牙桩编号
    private Date createdTime;

    public T3Log() {
    }

    public T3Log(String tid, String ip, String tversion, String unlockCode, String speed, String direct, int lockerStatusSpid,
                 int positioningStatusSpid, long gpstime, int availableSatellites, String signalstrength,
                 String batteryLevel, String batteryVoltage, String pid) {
        this.tid = tid;
        this.ip = ip;
        this.tversion = tversion;
        this.unlockCode = unlockCode;
        this.speed = speed;
        this.direct = direct;
        this.lockerStatusSpid = lockerStatusSpid;
        this.positioningStatusSpid = positioningStatusSpid;
        this.gpstime = gpstime;
        this.availableSatellites = availableSatellites;
        this.signalstrength = signalstrength;
        this.batteryLevel = batteryLevel;
        this.batteryVoltage = batteryVoltage;
        this.pid = pid;
    }

    public T3Log(String tid, String ip, Integer ttype, String tversion, String datagramId, Date datagramTime, String unlockCode,
                 String simno, String lng, String lat, String speed, String direct, int lockerStatusSpid,
                 int positioningStatusSpid, long gpstime, int availableSatellites, String signalstrength,
                 String batteryLevel, Integer mcc, Integer mnc, Integer lac, Integer cellid, Integer bsss,
                 String additionalBaseStation1, String additionalBaseStation2, String additionalBaseStation3,
                 String additionalBaseStation4, String additionalBaseStation5, String batteryVoltage, String pid, Date createdTime) {
        this.tid = tid;
        this.ip = ip;
        this.ttype = ttype;
        this.tversion = tversion;
        this.datagramId = datagramId;
        this.datagramTime = datagramTime;
        this.unlockCode = unlockCode;
        this.simno = simno;
        this.lng = lng;
        this.lat = lat;
        this.speed = speed;
        this.direct = direct;
        this.lockerStatusSpid = lockerStatusSpid;
        this.positioningStatusSpid = positioningStatusSpid;
        this.gpstime = gpstime;
        this.availableSatellites = availableSatellites;
        this.signalstrength = signalstrength;
        this.batteryLevel = batteryLevel;
        this.mcc = mcc;
        this.mnc = mnc;
        this.lac = lac;
        this.cellid = cellid;
        this.bsss = bsss;
        this.additionalBaseStation1 = additionalBaseStation1;
        this.additionalBaseStation2 = additionalBaseStation2;
        this.additionalBaseStation3 = additionalBaseStation3;
        this.additionalBaseStation4 = additionalBaseStation4;
        this.additionalBaseStation5 = additionalBaseStation5;
        this.batteryVoltage = batteryVoltage;
        this.pid = pid;
        this.createdTime = createdTime;

    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "TID", nullable = false, length = 32)
    public String getTid() {
        return this.tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Column(name = "TTYPE")
    public Integer getTtype() {
        return this.ttype;
    }

    public void setTtype(Integer ttype) {
        this.ttype = ttype;
    }

    @Column(name = "TVERSION", nullable = false, length = 16)
    public String getTversion() {
        return this.tversion;
    }

    public void setTversion(String tversion) {
        this.tversion = tversion;
    }

    @Column(name = "DATAGRAM_ID", length = 6)
    public String getDatagramId() {
        return this.datagramId;
    }

    public void setDatagramId(String datagramId) {
        this.datagramId = datagramId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATAGRAM_TIME", length = 19)
    public Date getDatagramTime() {
        return this.datagramTime;
    }

    public void setDatagramTime(Date datagramTime) {
        this.datagramTime = datagramTime;
    }

    @Column(name = "UNLOCK_CODE", nullable = false, length = 16)
    public String getUnlockCode() {
        return this.unlockCode;
    }

    public void setUnlockCode(String unlockCode) {
        this.unlockCode = unlockCode;
    }

    @Column(name = "SIMNO", length = 50)
    public String getSimno() {
        return this.simno;
    }

    public void setSimno(String simno) {
        this.simno = simno;
    }

    @Column(name = "LNG", length = 32)
    public String getLng() {
        return this.lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Column(name = "LAT", length = 32)
    public String getLat() {
        return this.lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Column(name = "SPEED", nullable = false, length = 16)
    public String getSpeed() {
        return this.speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @Column(name = "DIRECT", nullable = false, length = 10)
    public String getDirect() {
        return this.direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    @Column(name = "LOCKER_STATUS_SPID", nullable = false)
    public int getLockerStatusSpid() {
        return this.lockerStatusSpid;
    }

    public void setLockerStatusSpid(int lockerStatusSpid) {
        this.lockerStatusSpid = lockerStatusSpid;
    }

    @Column(name = "POSITIONING_STATUS_SPID", nullable = false)
    public int getPositioningStatusSpid() {
        return this.positioningStatusSpid;
    }

    public void setPositioningStatusSpid(int positioningStatusSpid) {
        this.positioningStatusSpid = positioningStatusSpid;
    }

    @Column(name = "GPSTIME", nullable = false)
    public long getGpstime() {
        return this.gpstime;
    }

    public void setGpstime(long gpstime) {
        this.gpstime = gpstime;
    }

    @Column(name = "AVAILABLE_SATELLITES", nullable = false)
    public int getAvailableSatellites() {
        return this.availableSatellites;
    }

    public void setAvailableSatellites(int availableSatellites) {
        this.availableSatellites = availableSatellites;
    }

    @Column(name = "SIGNALSTRENGTH", nullable = false, length = 16)
    public String getSignalstrength() {
        return this.signalstrength;
    }

    public void setSignalstrength(String signalstrength) {
        this.signalstrength = signalstrength;
    }

    @Column(name = "BATTERY_LEVEL", nullable = false, length = 16)
    public String getBatteryLevel() {
        return this.batteryLevel;
    }

    public void setBatteryLevel(String batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Column(name = "MCC")
    public Integer getMcc() {
        return this.mcc;
    }

    public void setMcc(Integer mcc) {
        this.mcc = mcc;
    }

    @Column(name = "MNC")
    public Integer getMnc() {
        return this.mnc;
    }

    public void setMnc(Integer mnc) {
        this.mnc = mnc;
    }

    @Column(name = "LAC")
    public Integer getLac() {
        return this.lac;
    }

    public void setLac(Integer lac) {
        this.lac = lac;
    }

    @Column(name = "CELLID")
    public Integer getCellid() {
        return this.cellid;
    }

    public void setCellid(Integer cellid) {
        this.cellid = cellid;
    }

    @Column(name = "BSSS")
    public Integer getBsss() {
        return this.bsss;
    }

    public void setBsss(Integer bsss) {
        this.bsss = bsss;
    }

    @Column(name = "ADDITIONAL_BASE_STATION1", length = 15)
    public String getAdditionalBaseStation1() {
        return this.additionalBaseStation1;
    }

    public void setAdditionalBaseStation1(String additionalBaseStation1) {
        this.additionalBaseStation1 = additionalBaseStation1;
    }

    @Column(name = "ADDITIONAL_BASE_STATION2", length = 15)
    public String getAdditionalBaseStation2() {
        return this.additionalBaseStation2;
    }

    public void setAdditionalBaseStation2(String additionalBaseStation2) {
        this.additionalBaseStation2 = additionalBaseStation2;
    }

    @Column(name = "ADDITIONAL_BASE_STATION3", length = 15)
    public String getAdditionalBaseStation3() {
        return this.additionalBaseStation3;
    }

    public void setAdditionalBaseStation3(String additionalBaseStation3) {
        this.additionalBaseStation3 = additionalBaseStation3;
    }

    @Column(name = "ADDITIONAL_BASE_STATION4", length = 15)
    public String getAdditionalBaseStation4() {
        return this.additionalBaseStation4;
    }

    public void setAdditionalBaseStation4(String additionalBaseStation4) {
        this.additionalBaseStation4 = additionalBaseStation4;
    }

    @Column(name = "ADDITIONAL_BASE_STATION5", length = 15)
    public String getAdditionalBaseStation5() {
        return this.additionalBaseStation5;
    }

    public void setAdditionalBaseStation5(String additionalBaseStation5) {
        this.additionalBaseStation5 = additionalBaseStation5;
    }

    @Column(name = "BATTERY_VOLTAGE")
    public String getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(String batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    @Column(name = "PID")
    public String getPid() {
        return this.pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_TIME", length = 19)
    public Date getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Column(name = "IP")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "T3Log [id=" + id + ", tid=" + tid + ", ip=" + ip + ", ttype=" + ttype + ", tversion=" + tversion
                + ", datagramId=" + datagramId + ", datagramTime=" + datagramTime + ", unlockCode=" + unlockCode
                + ", simno=" + simno + ", lng=" + lng + ", lat=" + lat + ", speed=" + speed + ", direct=" + direct
                + ", lockerStatusSpid=" + lockerStatusSpid + ", positioningStatusSpid=" + positioningStatusSpid
                + ", gpstime=" + gpstime + ", availableSatellites=" + availableSatellites + ", signalstrength="
                + signalstrength + ", batteryLevel=" + batteryLevel + ", mcc=" + mcc + ", mnc=" + mnc + ", lac=" + lac
                + ", cellid=" + cellid + ", bsss=" + bsss + ", additionalBaseStation1=" + additionalBaseStation1
                + ", additionalBaseStation2=" + additionalBaseStation2 + ", additionalBaseStation3="
                + additionalBaseStation3 + ", additionalBaseStation4=" + additionalBaseStation4
                + ", additionalBaseStation5=" + additionalBaseStation5 + ", batteryVoltage=" + batteryVoltage + ", pid="
                + pid + ", createdTime=" + createdTime + "]";
    }

}

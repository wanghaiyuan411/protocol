package com.wlcxbj.tcp.trade;

import com.wlcxbj.tcp.Repo.T3Repo;
import com.wlcxbj.tcp.entity.MsgWrapper;
import com.wlcxbj.tcp.entity.T3Entity;
import com.wlcxbj.tcp.entity.T3Log;
import com.wlcxbj.tcp.util.ConstantAPI;
import com.wlcxbj.tcp.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.util.Date;

@Slf4j(topic = "t3")
@Component
public class T3Handler extends AbstractTrade {
@Autowired
private T3Repo t3Repo;
    @Override
    public void handler(MsgWrapper msgWrapper, IoSession session) {
        T3Entity t3Entity = parseMsg(msgWrapper);
        String msgId = msgWrapper.getMsgId();
        String msgType = msgWrapper.getMsgType();
        //存储数据
        T3Log t3Log = new T3Log();
        t3Log.setTtype(111);
        t3Repo.save(t3Log);
        //通知app服务
        String param = ConstantAPI.END_ORDERID_LIFE;
        response(msgId, msgType, param, session);
    }
    private T3Entity parseMsg(MsgWrapper msgWrapper){
        T3Entity t3 = new T3Entity();
        try {
            t3.setDate(Util.string2Date(msgWrapper.getDate()));
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
        t3.setTtype(msgWrapper.getTtype());
        t3.setVersion(msgWrapper.getVersion());
        t3.setSerilId(msgWrapper.getSerilId());
        t3.setMsgId(msgWrapper.getMsgId());
        t3.setMsgType(msgWrapper.getMsgType());
        String[] body = msgWrapper.getBody();
        t3.setPositioningStatusSpid(Integer.parseInt(body[0]));
        t3.setLng(body[1] + "," + body[2]);
        t3.setLat(body[3] + "," + body[4]);
        t3.setSpeed(body[5]);
        t3.setDirect(body[6]);
        int lockcode  = Integer.parseInt(body[7]);
        t3.setUnlockCode((lockcode >> 5) + "");
        t3.setLockerStatusSpid((lockcode & 16) >> 4);
        String[] cellIdInfos = body[8].split("\\|");
        String[] cellids = cellIdInfos[0].split("\\:");
        t3.setMcc(Integer.parseInt(cellids[0]));
        t3.setMnc(Integer.parseInt(cellids[1]));
        t3.setLac(Integer.parseInt(cellids[2]));
        t3.setCellid(Integer.parseInt(cellids[3]));
        t3.setBsss(Integer.parseInt(cellids[4]));
        try{
            t3.setAdditionalBaseStation1(cellIdInfos[1]);
            t3.setAdditionalBaseStation2(cellIdInfos[2]);
            t3.setAdditionalBaseStation3(cellIdInfos[3]);
            t3.setAdditionalBaseStation4(cellIdInfos[4]);
            t3.setAdditionalBaseStation5(cellIdInfos[5]);
        }catch (Exception e){
            log.info(e.getMessage());
        }
        t3.setAvailableSatellites(Integer.parseInt(body[9].substring(0,1)));
        t3.setSignalstrength(body[9].substring(1,2));
        t3.setBatteryLevel(body[9].substring(2,3));
        t3.setBatteryVoltage(body[10]);
        String[] pids = body[11].split("\\;");
        try {
            t3.setPid1(pids[0]);
            t3.setPid2(pids[1]);
            t3.setPid3(pids[2]);
        }catch (Exception e){
            log.info(e.getMessage());
        }
        t3.setOrderId(body[12]);
        t3.setSceneCode(body[13]);
        t3.setMotorEletricity(body[14]);
        t3.setCreatedTime(new Date());
        log.info(t3.toString());
        return t3;
    }

}

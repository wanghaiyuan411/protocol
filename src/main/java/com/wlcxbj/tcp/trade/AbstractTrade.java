package com.wlcxbj.tcp.trade;

import com.wlcxbj.tcp.entity.MsgWrapper;
import com.wlcxbj.tcp.util.ConstantAPI;
import com.wlcxbj.tcp.util.Util;
import org.apache.mina.core.session.IoSession;

public abstract class AbstractTrade {
    public void doHandler(MsgWrapper msgWrapper ,IoSession session){
        handler(msgWrapper, session);
    }
    public abstract void handler(MsgWrapper msgWrapper,IoSession session);
    public void response(String msgId, String msgType, String param, IoSession session){
        byte[] resp = makResponse(Util.nowString(), msgId, msgType, param);
        session.write(resp);
    }
    byte[] makResponse(String date, String msgId, String msgType, String param){
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(date);
        stringBuilder.append(ConstantAPI.SEPRATOR);
        stringBuilder.append(msgId);
        stringBuilder.append(ConstantAPI.SEPRATOR);
        stringBuilder.append(msgType);
        if (param != null){
            stringBuilder.append(ConstantAPI.SEPRATOR);
            stringBuilder.append(param);
        }
        stringBuilder.append("]");
        return stringBuilder.toString().getBytes();
    }

}

package com.wlcxbj.tcp.handler;

import com.wlcxbj.tcp.entity.MsgWrapper;
import com.wlcxbj.tcp.trade.T3Handler;
import lombok.extern.slf4j.Slf4j;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class WrapperHandler extends IoHandlerAdapter {
    Logger logger = LoggerFactory.getLogger(WrapperHandler.class);
    @Resource
    private T3Handler t3Handler;

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        // Empty handler
        MsgWrapper wrapper = (MsgWrapper) message;
        String msgType = wrapper.getMsgType();
        if (msgType.equals("T3")){
            t3Handler.doHandler(wrapper, session);
        }
    }
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        logger.info("session created...");
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        logger.info("session closed...");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        super.sessionIdle(session, status);
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        logger.error("exception = " + cause.getCause());
    }
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        super.messageSent(session, message);
    }

    @Override
    public void inputClosed(IoSession session) throws Exception {
        super.inputClosed(session);
    }
}

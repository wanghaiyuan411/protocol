package com.wlcxbj.tcp.config;

import com.wlcxbj.tcp.code.Decode;
import com.wlcxbj.tcp.code.Encoder;
import com.wlcxbj.tcp.handler.WrapperHandler;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.InetSocketAddress;
@Component
public class MinaConfig {
    private MinaProperties minaProperties;
    private static InetSocketAddress inetSocketAddress;
    private IoAcceptor ioAcceptor = null;
    private WrapperHandler wrapperHandler;
    @Autowired
    public MinaConfig(MinaProperties minaProperties, WrapperHandler wrapperHandler){
        this.minaProperties = minaProperties;
        this.wrapperHandler = wrapperHandler;
    }
    public void run(){
        inetSocketAddress = new InetSocketAddress(minaProperties.getPort());
        try {
            if (ioAcceptor == null){
                ioAcceptor = new NioSocketAcceptor();
            }
            ioAcceptor.setHandler(wrapperHandler);
            ((NioSocketAcceptor)ioAcceptor).setReuseAddress(true);
            DefaultIoFilterChainBuilder chain = ioAcceptor.getFilterChain();
            chain.addLast("codec", new ProtocolCodecFilter(new Encoder(), new Decode()));
            ioAcceptor.bind(inetSocketAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void destroy(){
        ioAcceptor.unbind(inetSocketAddress);
    }


}

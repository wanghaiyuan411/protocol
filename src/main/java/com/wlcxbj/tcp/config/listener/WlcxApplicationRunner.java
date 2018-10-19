package com.wlcxbj.tcp.config.listener;

import com.wlcxbj.tcp.config.MinaConfig;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class WlcxApplicationRunner implements ApplicationRunner{
    private MinaConfig minaConfig;
    public WlcxApplicationRunner(MinaConfig minaConfig){
        this.minaConfig = minaConfig;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) {
        minaConfig.run();
    }
}

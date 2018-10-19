/*
package com.wlcxbj.tcp.config.listener;

import com.wlcxbj.tcp.config.MinaConfig;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MinaListener implements ServletContextListener {
    private MinaConfig minaConfig;
    public MinaListener(MinaConfig minaConfig){
        this.minaConfig = minaConfig;
    }
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        minaConfig.run();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        minaConfig.destroy();
    }
}
*/

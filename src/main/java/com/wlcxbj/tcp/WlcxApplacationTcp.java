package com.wlcxbj.tcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import java.util.Arrays;
@EnableAuthorizationServer
@SpringBootApplication
@ComponentScan(value = {"com.wlcxbj.http","com.wlcxbj.tcp"})
public class WlcxApplacationTcp {
    public static void main(String[] args) {
        System.out.println("args = " + Arrays.asList(args));
        SpringApplication.run(WlcxApplacationTcp.class, args);
    }
}
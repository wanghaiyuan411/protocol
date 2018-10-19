package com.wlcxbj.http.config;

import com.wlcxbj.http.config.security.intercepter.VerifySignInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import javax.annotation.Resource;

@Configuration
public class WebConfigration extends WebMvcConfigurerAdapter{
    @Resource
    private VerifySignInterceptor verifySignInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(verifySignInterceptor).addPathPatterns("/biz/**");
    }
}

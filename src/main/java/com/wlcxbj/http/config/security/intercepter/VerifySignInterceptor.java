package com.wlcxbj.http.config.security.intercepter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wlcxbj.http.config.configUtil.EncryptUtil;
import com.wlcxbj.http.model.RespBase;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Log4j
@Component
public class VerifySignInterceptor extends HandlerInterceptorAdapter{
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, String[]> requestMap = request.getParameterMap();
        if (EncryptUtil.isSignatrueLegal(requestMap)){
            return true;
        }
        errorResponse(response);
        return false;
    }
    private void errorResponse(HttpServletResponse response){
        try {
            PrintWriter printWriter = response.getWriter();
            printWriter.print(objectMapper.writeValueAsString(new RespBase(RespBase.ERRORCODE_ERROR)));
            //printWriter.print(new RespBase(RespBase.ERRORCODE_ERROR).toString());
            response.setHeader(HttpHeaders.CONTENT_TYPE, org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.flushBuffer();
        } catch (IOException e) {
            log.error("Response error");
        }
    }
}
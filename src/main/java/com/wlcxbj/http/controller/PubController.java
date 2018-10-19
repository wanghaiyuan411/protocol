package com.wlcxbj.http.controller;

import com.wlcxbj.http.model.RespBase;
import com.wlcxbj.tcp.Repo.EndUserRepo;
import com.wlcxbj.tcp.entity.EndUser;
import com.wlcxbj.tcp.service.serviceImpl.EndUserService;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;
@Log4j
@Controller
@RequestMapping(path = "/pub")
public class PubController {
    @Resource
    private EndUserRepo endUserRepo;
    @Resource
    private EndUserService endUserService;
    @RequestMapping(path = "/mkpass", method = RequestMethod.POST)
    @ResponseBody
    public RespBase mkPass(String loginName){
        EndUser endUser = endUserRepo.findByLoginName(loginName);
        Random rand = new Random();
        int code = 1000 + rand.nextInt(8999);
        log.info(loginName + " = " + code);
        if (endUser == null){
            endUser = new EndUser();
            endUser.setLoginName(loginName);
            endUser.setAccountnonexpired(true);
            endUser.setAccountnonlocked(true);
            endUser.setCredentialsnonexpired(true);
            endUser.setCreatedTime(new Date());
            endUser.setUpdatedTime(new Date());
        }else {
            endUser.setUpdatedTime(new Date());
        }
        endUserService.saveEndUser(endUser, code);
        return new RespBase();
    }
}
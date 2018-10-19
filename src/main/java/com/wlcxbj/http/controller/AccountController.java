package com.wlcxbj.http.controller;
import com.wlcxbj.http.model.requestModel.ReqAccountResp;
import com.wlcxbj.http.model.responseModel.RespAccountModel;
import com.wlcxbj.tcp.model.EndUserModel;
import com.wlcxbj.tcp.service.serviceImpl.EndUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.annotation.security.PermitAll;


@Controller
@RequestMapping(path = "/account")
//@PreAuthorize("#oauth2.hasScope('appclientscope')")
//@PreAuthorize("hasRole('ROLE_ADMIN')")
@PermitAll
public class AccountController {
    @Resource
    private EndUserService endUserService;
    @RequestMapping(method = RequestMethod.POST, path = "/getAccount")
    @ResponseBody
    public RespAccountModel getAccount(@RequestBody ReqAccountResp req, OAuth2Authentication auth){
        RespAccountModel respAccountModel = new RespAccountModel();
        EndUserModel endUserModel = endUserService.findByEndUserId(req.getUserId());
        respAccountModel.setEndUserModel(endUserModel);
        return respAccountModel;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/getAccountUrlEncoded")
    @ResponseBody
    public RespAccountModel getAccountUrlencoded(@RequestBody ReqAccountResp req, OAuth2Authentication auth){
        RespAccountModel respAccountModel = new RespAccountModel();
        EndUserModel endUserModel = endUserService.findByEndUserId(req.getUserId());
        respAccountModel.setEndUserModel(endUserModel);
        return respAccountModel;
    }
}

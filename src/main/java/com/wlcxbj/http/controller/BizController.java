package com.wlcxbj.http.controller;

import com.wlcxbj.http.model.requestModel.ReqAccountResp;
import com.wlcxbj.http.model.responseModel.RespAccountModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/biz")
public class BizController {
    @RequestMapping(method = RequestMethod.POST, path = "/getAccount")
    @ResponseBody
    public RespAccountModel getAccount(ReqAccountResp req){
        RespAccountModel respAccountModel = new RespAccountModel();

        return respAccountModel;
    }
}

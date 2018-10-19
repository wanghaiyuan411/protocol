package com.wlcxbj.tcp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {
    @RequestMapping(method = RequestMethod.GET, path = "/get/hello")
    @ResponseBody
    public String test(){
        System.out.println("THis is test controller");
        return "Hello World!";
    }

}

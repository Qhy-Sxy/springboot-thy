package com.aaa.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 钱浩洋
 * @date 2019/9/16 - 8:52
 */
@Controller
public class TestController {

    @RequestMapping("test")
    public String test(){
        return "index";
    }
}

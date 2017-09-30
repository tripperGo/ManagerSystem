package com.company.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhaochuanzhen
 * @desc 主页Controller
 * @since 9:42 2017/9/28
 */
@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping("/mainPage.action")
    public String menuPage(){
        return "main";
    }

}

package com.company.test.controller;

import com.company.test.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author zhaochuanzhen
 * @desc 管理员用户Controller
 * @since 11:20 2017/9/28
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 查询管理员用户列表
     */
    @ResponseBody
    @RequestMapping("/querySysUserList.action")
    public Map querySysUserList() throws Exception{
        return sysUserService.querySysUserList();
    }

}

package com.company.test.controller;

import com.company.test.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @desc 权限管理Controller
 * @since 2017年9月27日09:12:24
 * @author zhaochuanzhen
 */
@Controller
@RequestMapping("/menu")
public class MennuController {

    @Autowired
    private MenuService menuService;

    /**
     * 查询菜单列表
     */
    @ResponseBody
    @RequestMapping("/menuList.action")
    public Map queryMenuList(String pid) throws Exception {
        return menuService.queryMenuList(pid);
    }

    /**
     * 查询完整菜单树列表
     */
    @ResponseBody
    @RequestMapping("/fullMenuTreeList.action")
    public Map fullMenuTreeList() throws Exception {
        return menuService.fullMenuTreeList();
    }

}

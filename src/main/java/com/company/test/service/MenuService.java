package com.company.test.service;

import java.util.Map;

/**
 * @desc 权限管理Service接口
 * @since 2017年9月27日09:12:24
 * @author zhaochuanzhen
 */
public interface MenuService {

    /**
     * 查询菜单列表
     * @return 菜单集合
     * @throws Exception 异常统一处理
     */
    Map queryMenuList(String pid) throws Exception;

    /**
     * 查询完整菜单树列表
     */
    Map fullMenuTreeList() throws Exception;
}

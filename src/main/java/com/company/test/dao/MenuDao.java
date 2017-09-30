package com.company.test.dao;

import com.company.test.model.SysMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaochuanzhen
 * @desc 权限Dao接口
 * @since 9:29 2017/9/27
 */
@Repository
public interface MenuDao {

    /**
     * 查询菜单列表
     * @return 菜单集合
     * @throws Exception 异常统一处理
     */
    List<SysMenu> queryMenuListByPid(String pid) throws Exception;

    /**
     * 查询完整菜单树列表
     */
    List<SysMenu> fullMenuTreeList() throws Exception;
}

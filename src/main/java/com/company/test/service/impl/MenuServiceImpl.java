package com.company.test.service.impl;

import com.company.test.dao.MenuDao;
import com.company.test.model.SysMenu;
import com.company.test.model.ZTreeModel;
import com.company.test.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaochuanzhen
 * @desc 权限管理Service实现类
 * @since 9:17 2017/9/27
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao permissionDao;

    /**
     * 查询菜单列表
     *
     * @return 菜单集合
     * @throws Exception 异常统一处理
     */
    @Override
    public Map queryMenuList(String pid) throws Exception {
        Map result = new HashMap();
        result.put("result", "success");
        result.put("data", permissionDao.queryMenuListByPid(pid));
        return result;
    }

    /**
     * 查询完整菜单树列表
     */
    @Override
    public Map fullMenuTreeList() throws Exception {
        Map result = new HashMap();
        List<SysMenu> menuList = permissionDao.fullMenuTreeList();
        List<ZTreeModel> zTreeModels = new ArrayList<>();
        menuList.forEach(menu -> {
            ZTreeModel zTreeModel = new ZTreeModel();
            zTreeModel.setId(menu.getId());
            zTreeModel.setName(menu.getMenuName());
            zTreeModel.setOpen("1".equals(menu.getIsOpen()) ? true : false);
            zTreeModel.setFile(menu.getMenuURL());
            zTreeModels.add(zTreeModel);
        });
        result.put("result", "success");
        result.put("data", zTreeModels);
        return result;
    }

}

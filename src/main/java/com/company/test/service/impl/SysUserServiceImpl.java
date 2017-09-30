package com.company.test.service.impl;

import com.company.test.dao.SysUserDao;
import com.company.test.model.SysUser;
import com.company.test.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaochuanzhen
 * @desc 管理员用户Service实现类
 * @since 11:28 2017/9/28
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    /**
     * 查询管理员用户列表
     */
    @Override
    public Map querySysUserList() throws Exception {
        Map<String, Object> result = new HashMap<>();
        List<SysUser> list = sysUserDao.querySysUserList();
        result.put("result","success");
        result.put("data",list);
        return result;
    }

    /**
     * 根据用户名和密码查询用户信息
     */
    @Override
    public SysUser queryUserByUsernamePassword(String userName, String password) throws Exception {
        SysUser user = sysUserDao.queryUserByUsernamePassword(userName, password);
        return user;
    }
}

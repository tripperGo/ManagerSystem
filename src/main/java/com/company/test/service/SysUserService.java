package com.company.test.service;

import com.company.test.model.SysUser;

import java.util.Map;

/**
 * @author zhaochuanzhen
 * @desc 管理员用户Service接口
 * @since 11:27 2017/9/28
 */
public interface SysUserService {

    /**
     * 查询管理员用户列表
     */
    Map querySysUserList() throws Exception;

    /**
     * 根据用户名和密码查询用户信息
     */
    SysUser queryUserByUsernamePassword(String userName, String password) throws Exception;
}

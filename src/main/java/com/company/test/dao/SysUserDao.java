package com.company.test.dao;

import com.company.test.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaochuanzhen
 * @desc 管理员用户Dao接口
 * @since 11:24 2017/9/28
 */
@Repository
public interface SysUserDao {

    /**
     * 查询管理员用户列表
     */
    List<SysUser> querySysUserList() throws Exception;

    /**
     * 根据用户名和密码查询用户信息
     */
    SysUser queryUserByUsernamePassword(@Param("userName") String userName, @Param("password") String password) throws Exception;
}

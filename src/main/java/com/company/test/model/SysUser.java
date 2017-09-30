package com.company.test.model;

import java.io.Serializable;

/**
 * @author zhaochuanzhen
 * @desc 用户实体类
 * @since 9:23 2017/9/27
 */
public class SysUser implements Serializable {

    private String id;
    private String userName;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

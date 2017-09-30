package com.company.test.model;

import java.io.Serializable;

/**
 * @author zhaochuanzhen
 * @desc 权限实体类
 * @since 9:25 2017/9/27
 */
public class SysMenu implements Serializable {

    private String id;//主键
    private String menuName;//菜单名
    private String parentMenuId;//父节点ID
    private String menuURL;//点击触发的URL
    private char isOpen;//是否展开
    private char hasButtonAuthority;//是否包含按钮权限
    private Integer orderNo;//排序

    public String getMenuURL() {
        return menuURL;
    }

    public void setMenuURL(String menuURL) {
        this.menuURL = menuURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public char getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(char isOpen) {
        this.isOpen = isOpen;
    }

    public char getHasButtonAuthority() {
        return hasButtonAuthority;
    }

    public void setHasButtonAuthority(char hasButtonAuthority) {
        this.hasButtonAuthority = hasButtonAuthority;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
}

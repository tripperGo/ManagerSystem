package com.company.test.model;

import java.io.Serializable;

/**
 * @author zhaochuanzhen
 * @desc ZTree组件实体类
 * @since 14:31 2017/9/30
 */
public class ZTreeModel implements Serializable {
    private String id;//唯一标识
    private String name;//节点名
    private boolean open;//是否展开
    private String file;//点击触发的URL

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}

package com.qf.travel.common.pojo.dto;

import java.io.Serializable;
import java.util.List;

public class Options implements Serializable {

    //父节点名称
    private String name;

    //子节点集合
    private List<Options> children;

    private Long id;

    private Long parentId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Options> getChildren() {
        return children;
    }

    public void setChildren(List<Options> children) {
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}

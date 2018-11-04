package com.qf.travel.common.pojo.dto;

import java.io.Serializable;

/**
 *封装前台传递过来的分页参数
 * pojo.dto 数据传输对象，业务逻辑层方法的返回值对象
 */
public class PageInfo implements Serializable {
    private int page;//从第几条开始显示
    private int limit;//每页显示的条数

    //计算页码
    public int getOffset() {
        return (page-1)*limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}

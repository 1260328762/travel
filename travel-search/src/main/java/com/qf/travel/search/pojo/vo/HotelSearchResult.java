package com.qf.travel.search.pojo.vo;

import com.qf.travel.manager.pojo.po.TbHotelCustom;

import java.util.List;

/**
 * 封装根据关键字查询到的酒店的结果集
 */
public class HotelSearchResult {

    private long totalCount;

    private int pageCount;

    private List<TbHotelCustom> data;

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<TbHotelCustom> getData() {
        return data;
    }

    public void setData(List<TbHotelCustom> data) {
        this.data = data;
    }
}

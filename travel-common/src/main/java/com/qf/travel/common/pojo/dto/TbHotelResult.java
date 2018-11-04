package com.qf.travel.common.pojo.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 用来封装页面表格所需要的属性
 * @param <T>
 */
public class TbHotelResult<T> implements Serializable {

    private int code;
    private String msg;
    private Long count;
    private List<T> data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

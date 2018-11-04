package com.qf.travel.common.pojo.dto;

import java.io.Serializable;
import java.util.List;

/**
 * layui的分页显示
 * @param <T>
 */
public class ItemResult<T> implements Serializable {
    private int code;//0正确 非0错误
    private String msg;//信息
    private long count;//总数量
    private List<T> data;//传递的数据集合

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

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

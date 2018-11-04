package com.qf.travel.manager.dao;

import com.qf.travel.manager.pojo.po.TbTravelOrderItem;
import com.qf.travel.manager.pojo.po.TbTravelOrderItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbTravelOrderItemMapper {
    int countByExample(TbTravelOrderItemExample example);

    int deleteByExample(TbTravelOrderItemExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbTravelOrderItem record);

    int insertSelective(TbTravelOrderItem record);

    List<TbTravelOrderItem> selectByExample(TbTravelOrderItemExample example);

    TbTravelOrderItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbTravelOrderItem record, @Param("example") TbTravelOrderItemExample example);

    int updateByExample(@Param("record") TbTravelOrderItem record, @Param("example") TbTravelOrderItemExample example);

    int updateByPrimaryKeySelective(TbTravelOrderItem record);

    int updateByPrimaryKey(TbTravelOrderItem record);
}
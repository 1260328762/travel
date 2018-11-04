package com.qf.travel.manager.dao;

import com.qf.travel.manager.pojo.po.TbHotelOrderItem;
import com.qf.travel.manager.pojo.po.TbHotelOrderItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbHotelOrderItemMapper {
    int countByExample(TbHotelOrderItemExample example);

    int deleteByExample(TbHotelOrderItemExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbHotelOrderItem record);

    int insertSelective(TbHotelOrderItem record);

    List<TbHotelOrderItem> selectByExample(TbHotelOrderItemExample example);

    TbHotelOrderItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbHotelOrderItem record, @Param("example") TbHotelOrderItemExample example);

    int updateByExample(@Param("record") TbHotelOrderItem record, @Param("example") TbHotelOrderItemExample example);

    int updateByPrimaryKeySelective(TbHotelOrderItem record);

    int updateByPrimaryKey(TbHotelOrderItem record);
}
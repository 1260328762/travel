package com.qf.travel.manager.dao;

import com.qf.travel.manager.pojo.po.TbHotelOrder;
import com.qf.travel.manager.pojo.po.TbHotelOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbHotelOrderMapper {
    int countByExample(TbHotelOrderExample example);

    int deleteByExample(TbHotelOrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(TbHotelOrder record);

    int insertSelective(TbHotelOrder record);

    List<TbHotelOrder> selectByExample(TbHotelOrderExample example);

    TbHotelOrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") TbHotelOrder record, @Param("example") TbHotelOrderExample example);

    int updateByExample(@Param("record") TbHotelOrder record, @Param("example") TbHotelOrderExample example);

    int updateByPrimaryKeySelective(TbHotelOrder record);

    int updateByPrimaryKey(TbHotelOrder record);
}
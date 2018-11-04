package com.qf.travel.manager.dao;

import com.qf.travel.manager.pojo.po.TbTravelOrder;
import com.qf.travel.manager.pojo.po.TbTravelOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbTravelOrderMapper {
    int countByExample(TbTravelOrderExample example);

    int deleteByExample(TbTravelOrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(TbTravelOrder record);

    int insertSelective(TbTravelOrder record);

    List<TbTravelOrder> selectByExample(TbTravelOrderExample example);

    TbTravelOrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") TbTravelOrder record, @Param("example") TbTravelOrderExample example);

    int updateByExample(@Param("record") TbTravelOrder record, @Param("example") TbTravelOrderExample example);

    int updateByPrimaryKeySelective(TbTravelOrder record);

    int updateByPrimaryKey(TbTravelOrder record);
}
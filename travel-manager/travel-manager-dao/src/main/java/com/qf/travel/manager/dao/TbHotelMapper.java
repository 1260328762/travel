package com.qf.travel.manager.dao;

import com.qf.travel.manager.pojo.po.TbHotel;
import com.qf.travel.manager.pojo.po.TbHotelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbHotelMapper {
    int countByExample(TbHotelExample example);

    int deleteByExample(TbHotelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbHotel record);

    int insertSelective(TbHotel record);

    List<TbHotel> selectByExample(TbHotelExample example);

    TbHotel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbHotel record, @Param("example") TbHotelExample example);

    int updateByExample(@Param("record") TbHotel record, @Param("example") TbHotelExample example);

    int updateByPrimaryKeySelective(TbHotel record);

    int updateByPrimaryKey(TbHotel record);
}
package com.qf.travel.manager.dao;

import com.qf.travel.manager.pojo.po.TbHotelCat;
import com.qf.travel.manager.pojo.po.TbHotelCatExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbHotelCatMapper {
    int countByExample(TbHotelCatExample example);

    int deleteByExample(TbHotelCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbHotelCat record);

    int insertSelective(TbHotelCat record);

    List<TbHotelCat> selectByExample(TbHotelCatExample example);

    TbHotelCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbHotelCat record, @Param("example") TbHotelCatExample example);

    int updateByExample(@Param("record") TbHotelCat record, @Param("example") TbHotelCatExample example);

    int updateByPrimaryKeySelective(TbHotelCat record);

    int updateByPrimaryKey(TbHotelCat record);
}
package com.qf.travel.manager.dao;

import com.qf.travel.manager.pojo.po.TbTravelCat;
import com.qf.travel.manager.pojo.po.TbTravelCatExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbTravelCatMapper {
    int countByExample(TbTravelCatExample example);

    int deleteByExample(TbTravelCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbTravelCat record);

    int insertSelective(TbTravelCat record);

    List<TbTravelCat> selectByExample(TbTravelCatExample example);

    TbTravelCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbTravelCat record, @Param("example") TbTravelCatExample example);

    int updateByExample(@Param("record") TbTravelCat record, @Param("example") TbTravelCatExample example);

    int updateByPrimaryKeySelective(TbTravelCat record);

    int updateByPrimaryKey(TbTravelCat record);
}
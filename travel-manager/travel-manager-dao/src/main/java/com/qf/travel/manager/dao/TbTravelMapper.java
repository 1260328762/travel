package com.qf.travel.manager.dao;

import com.qf.travel.manager.pojo.po.TbTravel;
import com.qf.travel.manager.pojo.po.TbTravelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbTravelMapper {
    int countByExample(TbTravelExample example);

    int deleteByExample(TbTravelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbTravel record);

    int insertSelective(TbTravel record);

    List<TbTravel> selectByExample(TbTravelExample example);

    TbTravel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbTravel record, @Param("example") TbTravelExample example);

    int updateByExample(@Param("record") TbTravel record, @Param("example") TbTravelExample example);

    int updateByPrimaryKeySelective(TbTravel record);

    int updateByPrimaryKey(TbTravel record);
}
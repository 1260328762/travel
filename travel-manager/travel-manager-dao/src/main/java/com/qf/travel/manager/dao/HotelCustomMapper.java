package com.qf.travel.manager.dao;

import com.qf.travel.common.pojo.dto.PageInfo;
import com.qf.travel.manager.pojo.po.TbHotel;
import com.qf.travel.manager.pojo.po.TbHotelCat;
import com.qf.travel.manager.pojo.po.TbHotelCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotelCustomMapper {

    Long getCount(@Param("hotel") TbHotel hotel);

    List<TbHotelCustom> hotelList(@Param("page") PageInfo page, @Param("hotel") TbHotelCustom hotel);

    List<TbHotelCat> HotelCatList();

    int hotelInsert(TbHotelCustom hotel);

    TbHotelCustom selectHotelById(TbHotelCustom hotel);

    int updateHotel(TbHotelCustom hotel);

    List<TbHotelCustom> selectHotelByStatus();
}

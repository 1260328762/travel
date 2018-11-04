package com.qf.travel.manager.service;

import com.qf.travel.common.pojo.dto.PageInfo;
import com.qf.travel.common.pojo.dto.TbHotelResult;
import com.qf.travel.manager.pojo.po.TbHotel;
import com.qf.travel.manager.pojo.po.TbHotelCat;
import com.qf.travel.manager.pojo.po.TbHotelCustom;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HotelService {
    TbHotelResult<TbHotelCustom> hotelList(PageInfo page, TbHotelCustom hotel);

    int modifyHotelStatus(TbHotel hotel, boolean flg);

    List<TbHotelCat> getHotelCatList();

    int hotelAdd(TbHotelCustom hotel);

    int upateBatch(List<Long> ids);

    TbHotelCustom findHotelById(TbHotelCustom hotel);

    int modifyHotel(TbHotelCustom hotel);

    int importIndexlib();

    String showCat();

    String uploadImage(MultipartFile file);
}

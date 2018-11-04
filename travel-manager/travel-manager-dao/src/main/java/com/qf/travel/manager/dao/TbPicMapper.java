package com.qf.travel.manager.dao;

import com.qf.travel.common.pojo.dto.PageInfo;
import com.qf.travel.common.pojo.po.TbPic;

import java.util.List;

public interface TbPicMapper {

    int insertImage(TbPic pic);

    List<TbPic> listPicByPage(PageInfo pageInfo);

}

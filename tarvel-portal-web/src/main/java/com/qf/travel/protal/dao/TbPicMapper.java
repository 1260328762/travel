package com.qf.travel.protal.dao;

import com.qf.travel.common.pojo.po.TbPic;

import java.util.List;

public interface TbPicMapper {


    List<TbPic> listPicByGroupId(int groupid);
}

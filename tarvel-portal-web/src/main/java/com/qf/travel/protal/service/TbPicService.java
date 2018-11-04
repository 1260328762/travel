package com.qf.travel.protal.service;

import com.qf.travel.common.pojo.po.TbPic;

import java.util.List;

public interface TbPicService {

    List<TbPic> listPicByGroupId(int groupid);
}

package com.qf.travel.manager.service;

import com.qf.travel.common.pojo.dto.PageInfo;
import com.qf.travel.common.pojo.po.TbPic;
import org.springframework.web.multipart.MultipartFile;

public interface PicService {

    String uploadImage(MultipartFile file);

    int addPic(TbPic pic);

    String listPicByPage(PageInfo pageInfo);
}

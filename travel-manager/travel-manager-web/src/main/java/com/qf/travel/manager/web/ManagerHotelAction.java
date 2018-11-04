package com.qf.travel.manager.web;

import com.qf.travel.common.pojo.dto.PageInfo;
import com.qf.travel.common.pojo.dto.TbHotelResult;
import com.qf.travel.manager.pojo.po.TbHotel;
import com.qf.travel.manager.pojo.po.TbHotelCat;
import com.qf.travel.manager.pojo.po.TbHotelCustom;
import com.qf.travel.manager.service.HotelService;
import com.qf.travel.manager.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ManagerHotelAction {

    @Autowired
    private HotelService service;

    @Autowired
    private PicService picService;


    /**
     * 酒店列表(包括模糊查询)
     * @param page
     * @param hotel
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/hotel/hotellist",method = RequestMethod.GET)
    public TbHotelResult hotelList(PageInfo page, TbHotelCustom hotel){

        TbHotelResult<TbHotelCustom> result = service.hotelList(page,hotel);
        return result;
    }



    /**
     * 修改酒店状态
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/hotel/chhotelstatus",method = RequestMethod.POST)
    public int modifyHotelStatus(TbHotel hotel,boolean flg){

        return service.modifyHotelStatus(hotel,flg);
    }


    /**
     * 获取数据库中所有酒店分类
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/hotel/hotelcat",method = RequestMethod.POST)
    public List<TbHotelCat> hotelCatList(){

        return service.getHotelCatList();

    }


    /**
     * 酒店增加
     * @param hotel
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/hotel/hoteladd",method = RequestMethod.POST)
    public int hotelAdd(TbHotelCustom hotel){
        return service.hotelAdd(hotel);
    }


    /**
     * 上传图片
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/uploadimage2")
    public String uploadImage(MultipartFile file) {
        return picService.uploadImage(file);
    }



    /**
     * 批量删除(修改状态值)
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/hotel/updatebatch")
    public int updateBatch(@RequestParam("ids[]") List<Long> ids){
        return service.upateBatch(ids);
    }



    /**
     * 根据id查询
     * @param session
     * @param hotel
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/hotel/hotelinfo")
    public List<TbHotelCat> hotelInfo(HttpSession session,TbHotelCustom hotel){
        hotel = service.findHotelById(hotel);
        List<TbHotelCat> list = service.getHotelCatList();
        session.setAttribute("hotel", hotel);

        return list;
    }


    /**
     * 修改酒店信息
     * @param hotel
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/hotel/hotelmofidy")
    public int modifyHotel(TbHotelCustom hotel){
        return service.modifyHotel(hotel);
    }


    /**
     * 导入索引库
     * @return
     */
    @ResponseBody
    @RequestMapping("/hotel/indexlib/import")
    public int importIndexlib(){
        return service.importIndexlib();
    }


    /**
     * 展示分类列表
     * @return
     */
    @RequestMapping(value = "/hotel/showcat")
    @ResponseBody
    public String showCat(){
        return service.showCat();
    }
}

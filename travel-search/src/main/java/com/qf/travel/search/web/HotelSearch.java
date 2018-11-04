package com.qf.travel.search.web;

import com.qf.travel.search.pojo.vo.HotelSearchResult;
import com.qf.travel.search.service.HotelSearchService;
import core.PropKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HotelSearch {

    @Autowired
    private HotelSearchService searchService;



    @RequestMapping(value = "/search")
    public String hotelSearch(String keyword, @RequestParam(defaultValue = "1")int pageIndex, Model model){
        int pageSize = PropKit.use("search.properties").getInt("search.pagesize");
        HotelSearchResult result = searchService.searchHotel(keyword,pageIndex,pageSize);
        model.addAttribute("result",result);
        return "hotelsearch";
    }
}

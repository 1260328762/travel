package com.qf.travel.search.service;

import com.qf.travel.search.pojo.vo.HotelSearchResult;

public interface HotelSearchService {
    HotelSearchResult searchHotel(String keyword, int pageIndex, int pageSize);
}

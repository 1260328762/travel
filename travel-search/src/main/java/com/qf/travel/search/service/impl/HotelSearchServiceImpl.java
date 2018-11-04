package com.qf.travel.search.service.impl;

import com.qf.travel.search.dao.HotelSearchDao;
import com.qf.travel.search.pojo.vo.HotelSearchResult;
import com.qf.travel.search.service.HotelSearchService;
import org.apache.solr.client.solrj.SolrQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelSearchServiceImpl implements HotelSearchService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HotelSearchDao searchDao;


    @Override
    public HotelSearchResult searchHotel(String keyword, int pageIndex, int pageSize) {

        HotelSearchResult result = null;

        try {
            //创建查询对象用来封装查询条件
            SolrQuery query = new SolrQuery();
            //封装关键字
            query.setQuery(keyword);

            //设置分页属性
            query.setStart((pageIndex - 1) * pageSize);
            query.setRows(pageSize);

            //设置要查询的字段
            query.set("df", "hotel_keywords");

            //设置高亮显示
            query.setHighlight(true);
            query.addHighlightField("hotel_name");
            query.setHighlightSimplePre("<em style='color:red'>");
            query.setHighlightSimplePost("</em>");

            result = searchDao.search(query, pageSize);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return result;
    }
}

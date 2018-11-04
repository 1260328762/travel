package com.qf.travel.search.dao;

import com.qf.travel.manager.pojo.po.TbHotelCustom;
import com.qf.travel.search.pojo.vo.HotelSearchResult;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class HotelSearchDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SolrServer solrServer;

    public HotelSearchResult search(SolrQuery query, int pageSize) {

        HotelSearchResult result = new HotelSearchResult();
        List<TbHotelCustom> list = new ArrayList<>();
        try {
            //获取查询总结果
            QueryResponse response = solrServer.query(query);
            SolrDocumentList results = response.getResults();

            //获取查询总记录数
            long totalCount = results.getNumFound();
            //获取计算总页数
            result.setPageCount((int) ((totalCount + pageSize - 1) / pageSize));
            result.setTotalCount(totalCount);

            //获取高亮酒店名称
            Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
            //遍历结果,进行封装
            for (SolrDocument document : results) {
                TbHotelCustom hotel = new TbHotelCustom();
                String id = (String) document.get("id");
                hotel.setId(Long.parseLong(id));
                hotel.setContent((String) document.get("hotel_content"));
                hotel.setImage((String) document.get("hotel_image"));
                hotel.setNum((Integer) document.get("hotel_num"));
                hotel.setRestof((Integer) document.get("hotel_restof"));
                hotel.setPrice((Long) document.get("hotel_price"));

                //根据id获取高亮酒店名称
                List<String> highName = highlighting.get(document.get("id")).get("hotel_name");

                //根据id判断对应的酒店标题是否为空
                String hotelName = "";
                if (highName != null && !highName.isEmpty()) {
                    hotelName = highName.get(0);
                }else{
                    hotelName = (String) document.get("hotel_name");
                }
                hotel.setName(hotelName);
                list.add(hotel);
            }
            result.setData(list);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }

        return result;
    }
}

package com.qf.tarvel.manager.listener;

import com.qf.travel.manager.dao.HotelCustomMapper;
import com.qf.travel.manager.pojo.po.TbHotelCustom;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class HotelAddListener implements MessageListener {

    @Autowired
    private SolrServer solrServer;

    @Autowired
    private HotelCustomMapper hotelCustomMapper;

    @Override
    public void onMessage(Message message) {
        // 获取消息
        TextMessage textMessage = (TextMessage) message;
        //获取酒店id
        try {
            long id = Long.parseLong(textMessage.getText());
            //根据id查询酒店信息
            TbHotelCustom hotel = new TbHotelCustom();
            hotel.setId(id);
            hotel = hotelCustomMapper.selectHotelById(hotel);
            //导入索引库
            SolrInputDocument document = new SolrInputDocument();
            document.addField("id", hotel.getId());
            document.addField("hotel_name", hotel.getName());
            document.addField("hotel_content", hotel.getContent());
            document.addField("hotel_num", hotel.getNum());
            document.addField("hotel_restof", hotel.getRestof());
            document.addField("hotel_price", hotel.getPrice());
            document.addField("hotel_image", hotel.getImage());
            solrServer.add(document);
            solrServer.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

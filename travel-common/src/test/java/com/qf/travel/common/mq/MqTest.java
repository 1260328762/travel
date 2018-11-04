// package com.qf.travel.common.mq;
//
// import org.apache.activemq.ActiveMQConnectionFactory;
// import org.junit.Test;
//
// import javax.jms.*;
// import java.io.IOException;
//
// public class MqTest {
//
//
//     /**
//      * 消息发送端
//      */
//     @Test
//     public void testProducer() throws JMSException {
//
//         //创建连接工厂
//         ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://47.95.15.181:61616");
//
//         //创建连接对象
//         Connection connection = factory.createConnection();
//
//         //开启连接
//         connection.start();
//         //创建会话
//         //第一个参数:true,开启事务
//         //第二个参数,应答模式,自动应答即可
//         Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//
//         //创建队列
//         Queue queue = session.createQueue("test-queue");
//         //创建生产者对象
//         MessageProducer producer = session.createProducer(queue);
//         //创建消息对象
//         TextMessage textMessage = session.createTextMessage("Hello ActiveMq");
//         //发送消息
//         producer.send(textMessage);
//
//         //关闭资源
//         producer.close();
//         session.close();
//         connection.close();
//     }
//
//
//
//     /**
//      * 消息接收端
//      */
//     @Test
//     public void  testConsumer() throws JMSException, IOException {
//         //创建连接工厂
//         ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://47.95.15.181:61616");
//         //获取连接对象
//         Connection connection = factory.createConnection();
//         //开启连接
//         connection.start();
//         //创建回话
//         Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//         //创建队列,队列名称要和发送端的一样
//         Queue queue = session.createQueue("test-queue");
//         //创建消费者对象
//         MessageConsumer consumer = session.createConsumer(queue);
//         //监听消息
//         consumer.setMessageListener(new MessageListener() {
//             @Override
//             public void onMessage(Message message) {
//                 TextMessage textMessage = (TextMessage) message;
//                 //获取消息
//                 try {
//                     String text = textMessage.getText();
//                     System.out.println(text);
//                 } catch (JMSException e) {
//                     e.printStackTrace();
//                 }
//             }
//         });
//         System.in.read();
//         //关闭资源
//         consumer.close();
//         session.close();
//         connection.close();
//     }
// }

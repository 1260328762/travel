//
// package com.qf.travel.common.redis;
//
// import org.junit.Test;
// import redis.clients.jedis.HostAndPort;
// import redis.clients.jedis.Jedis;
// import redis.clients.jedis.JedisCluster;
// import redis.clients.jedis.JedisPool;
//
// import javax.naming.Name;
// import java.io.IOException;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;
//
//
// /**
//  * 测试redis集群
//  */
//
// public class RedisTest {
//
//
//     /**
//      * 单机版本测试
//      */
//
//     @Test
//     public void testJedis1() {
//         //获取jedis对象
//         Jedis jedis = new Jedis("47.95.15.181", 6379);
//         //设置密码
//         jedis.auth("admin");
//         //给redis设置值
//         String s = jedis.set("name", "chenliang");
//         System.out.println(s);
//         jedis.lpush("list1", new String[]{"a", "b", "c"});
//
//         //取值
//         String name = jedis.get("name");
//         System.out.println(name);
//         List<String> list = jedis.lrange("list1", 0, -1);
//         System.out.println(list);
//         jedis.close();
//     }
//
//
//     /**
//      * 连接池版本测试
//      *//*
//
//     @Test
//     public void testJedis2(){
//         JedisPool pool = new JedisPool("47.95.15.181",6379);
//         Jedis jedis = pool.getResource();
//         jedis.auth("admin");
//         String name = jedis.get("name");
//         System.out.println(name);
//     }
//
//
//
//
// /**
//      * 集群版本
//      */
//     @Test
//     public void testJedis3() throws IOException {
//         //获取集合
//         Set<HostAndPort> set = new HashSet<>();
//         set.add(new HostAndPort("47.95.15.181", 7001));
//         set.add(new HostAndPort("47.95.15.181", 7002));
//         set.add(new HostAndPort("47.95.15.181", 7003));
//         set.add(new HostAndPort("47.95.15.181", 7004));
//         set.add(new HostAndPort("47.95.15.181", 7005));
//         set.add(new HostAndPort("47.95.15.181", 7006));
//
//         //获取redis集群
//         JedisCluster cluster = new JedisCluster(set);
//
//         //设值
//         cluster.set("name", "chenliang");
//
//
//         //取值
//         System.out.println(cluster.get("name"));
//
//         cluster.close();
//
//     }
// }

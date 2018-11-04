package com.qf.travel.common.jedis;

import java.util.List;
import java.util.Map;

public interface JedisClient {

    //String类型封装
    String set(String key,String value);

    String get(String key);

    Boolean exists(String key);

    Long expire(String key ,int second);


    //List类型封装
    Long lpush(String key,String... value);

    Long rpush(String key,String... value);

    List<String> lrange(String key,long start,long end);


    //hash类型的封装
    Long hset(String key,String field,String value);

    String hget(String key,String field);

    String hmset(String key, Map<String, String> hash);

    List<String> hmget(String key, String... value);



}

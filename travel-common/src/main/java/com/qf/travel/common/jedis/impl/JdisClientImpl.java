package com.qf.travel.common.jedis.impl;

import com.qf.travel.common.jedis.JedisClient;
import redis.clients.jedis.JedisCluster;
import java.util.List;
import java.util.Map;

public class JdisClientImpl implements JedisClient {

    private JedisCluster cluster;

    public JedisCluster getCluster() {
        return cluster;
    }

    public void setCluster(JedisCluster cluster) {
        this.cluster = cluster;
    }

    @Override
    public String set(String key, String value) {
        return cluster.set(key, value);
    }

    @Override
    public String get(String key) {
        return cluster.get(key);
    }

    @Override
    public Boolean exists(String key) {
        return cluster.exists(key);
    }

    @Override
    public Long expire(String key, int second) {
        return cluster.expire(key, second);
    }

    @Override
    public Long lpush(String key, String... value) {
        return cluster.lpush(key,value);
    }

    @Override
    public Long rpush(String key, String... value) {
        return cluster.rpush(key, value);
    }

    @Override
    public List<String> lrange(String key, long start, long end) {
        return cluster.lrange(key, start, end);
    }

    @Override
    public Long hset(String key, String field, String value) {
        return cluster.hset(key, field, value);
    }

    @Override
    public String hget(String key, String field) {
        return cluster.hget(key, field);
    }

    @Override
    public String hmset(String key, Map<String, String> hash) {
        return hmset(key, hash);
    }

    @Override
    public List<String> hmget(String key, String... value) {
        return hmget(key, value);
    }
}

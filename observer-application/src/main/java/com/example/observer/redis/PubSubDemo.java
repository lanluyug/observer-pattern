package com.example.observer.redis;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author lanluyug
 */
@Slf4j
public class PubSubDemo {

    public static void main( String[] args )
    {
        // 连接redis服务端
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "192.168.145.129", 6379);

        log.info(String.format("redis pool启动成功, redis ip %s, redis port %d", "192.168.145.129", 6379));
        // 频道，类似于topic，订阅者和发布者通过channel通信
        String channel = "mychannel";
        // 订阅者
        SubThread subThread = new SubThread(jedisPool, "小明", channel);
        subThread.start();
        // 订阅者
        SubThread subThread2 = new SubThread(jedisPool, "小张", channel);
        subThread2.start();

        // 发布者，发布者无需维护订阅者的引用
        RedisPublisher redisPublisher = new RedisPublisher(jedisPool, channel);
        redisPublisher.start();
    }
}
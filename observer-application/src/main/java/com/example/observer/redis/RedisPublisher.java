package com.example.observer.redis;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lanluyug
 * 发布者
 */
@Slf4j
public class RedisPublisher extends Thread{

    private final JedisPool jedisPool;

    private final String channel;

    public RedisPublisher(JedisPool jedisPool, String channel) {
        this.jedisPool = jedisPool;
        this.channel = channel;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //连接池中取出一个连接
        Jedis jedis = jedisPool.getResource();
        while (true) {
            String msg;
            try {
                msg = reader.readLine();
                if (!"quit".equals(msg)) {
                    //在 mychannel 的频道上推送消息
                    jedis.publish(channel, msg);
                    log.info("发布了一条消息：{}在{}频道上", msg, channel);
                } else {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
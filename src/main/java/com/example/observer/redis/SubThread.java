package com.example.observer.redis;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author lanluyug
 */
@Slf4j
public class SubThread extends Thread {

    private final JedisPool jedisPool;
    private final String channel;

    private final String name;

    public SubThread(JedisPool jedisPool, String name, String channel) {
        super("SubThread");
        this.jedisPool = jedisPool;
        this.name = name;
        this.channel = channel;
    }

    @Override
    public void run() {
        log.info("{} subscribe redis成功, channel是 {}, 线程将被阻塞", name, channel);
        //取出一个连接
        try (Jedis jedis = jedisPool.getResource()) {
            //通过subscribe 的api去订阅，入参是订阅者和频道名
            jedis.subscribe(new RedisSubscriber(name), channel);
        } catch (Exception e) {
            log.info(String.format("subsrcibe channel error, %s", e));
        }
    }
}
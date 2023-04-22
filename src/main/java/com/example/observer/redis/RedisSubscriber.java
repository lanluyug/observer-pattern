package com.example.observer.redis;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.JedisPubSub;

/**
 * @author lanluyug
 * 订阅者
 */
@Slf4j
public class RedisSubscriber extends JedisPubSub {

    private final String name;

    public RedisSubscriber(String name){
        this.name = name;
    }

    @Override
    public void onMessage(String channel, String message) {       //收到消息会调用
        log.info("{}收到redis发布的消息, channel是{}, 消息是：{}", name, channel, message);
    }
    @Override
    public void onSubscribe(String channel, int subscribedChannels) {    //订阅了频道会调用
        log.info("{}订阅redis channel成功, channel是{}",
                name, channel);
    }
    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {   //取消订阅 会调用
        log.info("{}取消订阅 redis channel, channel是 {}", name, channel);

    }
}
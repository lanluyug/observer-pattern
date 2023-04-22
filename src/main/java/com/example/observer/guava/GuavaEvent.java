package com.example.observer.guava;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lanluyug
 */
@Slf4j
public class GuavaEvent {

    private final String name;

    public GuavaEvent(String name){
        this.name = name;
    }


    @Subscribe
    public void subscribeString(Message<String> message){
        if(Message.MessageType.STRING.equals(message.getType())){
            log.info("{}执行subscribeString方法，传入的参数是：{}",name, message.getMsg());
        }

    }

    @Subscribe
    public void subscribeDouble(Message<Double> message){
        if(Message.MessageType.DOUBLE.equals(message.getType())){
            log.info("{}执行subscribeDouble方法，传入的参数是：{}",name, message.getMsg());
        }
    }
}

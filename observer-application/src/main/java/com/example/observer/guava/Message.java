package com.example.observer.guava;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class Message<T> {

    private T msg;

    private MessageType type;

    public Message(T msg, MessageType type){
        this.msg = msg;
        this.type = type;
    }

    enum MessageType{
        /**
         * 类型，解耦事件处理器
         */
        STRING,
        DOUBLE
    }
}

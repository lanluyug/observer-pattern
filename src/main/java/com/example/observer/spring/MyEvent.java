package com.example.observer.spring;

import org.springframework.context.ApplicationEvent;

/**
 * @author lanluyug
 */
public class MyEvent extends ApplicationEvent {

    private String msg;
    public MyEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

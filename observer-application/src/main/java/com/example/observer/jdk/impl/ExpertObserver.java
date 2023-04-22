package com.example.observer.jdk.impl;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

/**
 * @author lanluyug
 */
@Slf4j
public class ExpertObserver implements Observer {

    private final String name;

    public ExpertObserver(String name){
        this.name = name;
    }

    /**
     * 收到信息该怎么做，由具体的观察者自己决定
     * @param o     the observable object.
     * @param arg   an argument passed to the <code>notifyObservers</code>
     *                 method.
     */
    @Override
    public void update(Observable o, Object arg) {
        if("出主意".equals(arg)){
            log.info(name + "知道了，我们要先......");
            log.info("============================");
        }
    }
}

package com.example.observer.jdk.impl;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

/**
 * @author lanluyug
 */

@Slf4j
public class TesterObserver implements Observer {

    private final String name;

    public TesterObserver(String name){
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
        if(arg instanceof String) {
            log.info(name + "知道了，需求是{}, 开始写测试用例......", arg);
            log.info("============================");
        }
    }

}

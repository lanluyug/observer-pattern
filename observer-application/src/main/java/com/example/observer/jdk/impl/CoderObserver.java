package com.example.observer.jdk.impl;

import com.example.observer.jdk.JdkPublisher;
import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

/**
 * @author Administrator
 */

@Slf4j
public class CoderObserver implements Observer {

    private final String name;

    public CoderObserver(String name){
        this.name = name;
    }

    /**
     * 收到信息该怎么做，由具体的观察者自己决定
     * @param o     the observable object. 为pull模式提供特色的方法
     * @param arg   an argument passed to the <code>notifyObservers</code>
     *                 method. push模式直接输出信息
     */
    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof String || o instanceof JdkPublisher){
            log.info(name + "知道了，需求是{}, 开始写代码......", Optional.ofNullable((String)arg)
                    // 自己“拉”取数据, 推在消息传递上比拉的优势更强，但在耗时的行为上，拉比推更灵活
                    // 在jdk提供的Observable类，拉和推并没有太大的实质性区别
                    .orElseGet(() -> ((JdkPublisher)o).getMsg()));
            log.info("============================");
        }
    }

}

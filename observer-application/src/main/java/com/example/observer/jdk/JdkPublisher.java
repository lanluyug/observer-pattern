package com.example.observer.jdk;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * 监听是否有新消息，把风的，相当于特殊的中介
 * 管理观察者并通知观察者。
 */
@Slf4j
public class JdkPublisher extends Observable implements Observer {

    private String msg;

    /**
     * 推送消息（广播）
     */
    public void push(String msg) {
        log.info("有需求来了.....");
        // 更改状态为true
        super.setChanged();
        /*
         * 如果有变化，则通知所有人
         * 发布订阅有“推”、“拉”两种模式，此为推模式，即将msg直接传递给观察者
         * notifyObservers可以放在此处，也可以和super.setChanged()分离
         */
        notifyObservers(msg);
    }

    /**
     * “拉”模式（广播），不直接传递消息
     */
    public void pull(){
        log.info("有需求来了.....");
        // 更改状态为true
        super.setChanged();
        /*
         * “拉”模式,不直接传递消息体
         */
        notifyObservers();
    }

    /**
     * 测试广播链的问题
     * @param o     the observable object.
     * @param arg   an argument passed to the <code>notifyObservers</code>
     *                 method.
     */
    @Override
    public void update(Observable o, Object arg) {
        log.info("................");
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // 无论是JdkMonitor对象从Observable传入，还是从arg传入，都可能引起广播链问题
        ((JdkPublisher)o).push("");
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

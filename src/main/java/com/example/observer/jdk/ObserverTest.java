package com.example.observer.jdk;

import com.example.observer.jdk.impl.CoderObserver;
import com.example.observer.jdk.impl.ExpertObserver;
import com.example.observer.jdk.impl.TesterObserver;
import com.example.util.Utils;
import lombok.extern.slf4j.Slf4j;

import java.util.Observable;

/**
 * @author lanluyug
 * 总结：
 * + 使用面向对象的抽象，Observer模式使得我们可以独立地改变目标与观察者，从而使二者之间的依赖关系达致松耦合。
 * + 目标发送通知时，无需指定观察者，通知（可以携带通知信息作为参数）会自动传播。
 * + 观察者自己决定是否需要订阅通知，目标对象对此一无所知。
 * + Observer模式是基于事件的UI框架中非常常用的设计模式，也是MVC模式的一个重要组成部分。
 * 注意：
 * 当观察者比较多时，广播将耗费大量时间,需要异步处理
 * @see Observable notifyObservers
 * 广播链的问题
 */
@Slf4j
public class ObserverTest {

    public static void main(String[] args) {
        // 创建一个发布者
        JdkPublisher jdkPublisher = new JdkPublisher();

        // 订阅, 与发布者建立联系（记录引用）
        jdkPublisher.addObserver(new CoderObserver("小花"));
        jdkPublisher.addObserver(new CoderObserver("小明"));
        jdkPublisher.addObserver(new ExpertObserver("小三"));
        jdkPublisher.addObserver(new TesterObserver("小四"));

        // 广播链的问题
//         jdkPublisher.addObserver(jdkPublisher);

        // 监听键盘输入
        Utils.waitForKeyboard(msg -> {
            // 如果有新消息，则推送(Push模式)
            // jdkPublisher.push(msg);
            // Pull模式
            // 现在本地存储消息
            jdkPublisher.setMsg(msg);
            jdkPublisher.pull();
        });
    }
}

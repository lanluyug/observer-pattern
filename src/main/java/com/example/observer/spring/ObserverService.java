package com.example.observer.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 * @author lanluyug
 */
@Service
public class ObserverService implements CommandLineRunner {

    @Autowired
    private  MyEventPublish publish;

    public void publish(String msg) {
        publish.publish(new MyEvent(this, msg));
    }

    @Override
    public void run(String... args) throws Exception {
        publish("启动成功！");
    }
}

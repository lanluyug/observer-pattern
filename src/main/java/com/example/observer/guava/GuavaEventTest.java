package com.example.observer.guava;

import com.example.util.Utils;
import com.google.common.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lanluyug
 */
@Slf4j
public class GuavaEventTest {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        GuavaEvent guavaEvent = new GuavaEvent("小明");
        GuavaEvent guavaEvent2 = new GuavaEvent("小四");

        eventBus.register(guavaEvent);
        eventBus.register(guavaEvent2);

        Utils.waitForKeyboard(msg -> {
            try {
                double v = Double.parseDouble(msg);
                eventBus.post(new Message<>(v, Message.MessageType.DOUBLE));
            }catch (Exception e){
                eventBus.post(new Message<>(msg, Message.MessageType.STRING));
            }
        });

    }
}

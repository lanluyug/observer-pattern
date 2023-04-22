package com.example.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

/**
 * @author lanluyug
 */
@Slf4j
public class Utils {

    private Utils(){}

    public static void waitForKeyboard(Consumer<String> consumer){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String msg;
            try {
                msg = reader.readLine();
                if (!"quit".equals(msg)) {
                    consumer.accept(msg);
                    log.info("发布了一条消息：{}", msg);
                } else {
                    break;
                }
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}

package com.example.observer.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;

/**
 * @author lanluyug
 */
@Slf4j
public class SimpleConsumer {

    public static void main(String[] args) {

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(KafkaConfig.getProperties());

        consumer.subscribe(Collections.singletonList(KafkaConfig.getTopic()));

        try{
            while (true){
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));

                for(ConsumerRecord<String, String> record : records){
                    log.info("offset= {}, key= {}, value={}",
                            record.offset(), record.key(), record.value());
                }
            }
        }finally {
            consumer.close();
        }
    }
}

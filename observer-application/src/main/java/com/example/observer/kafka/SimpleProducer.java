package com.example.observer.kafka;

import com.example.util.Utils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.concurrent.ExecutionException;

public class SimpleProducer {

    public static void main(String[] args){
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(KafkaConfig.getProperties())) {
            Utils.waitForKeyboard( msg ->{
                ProducerRecord<String, String> producerRecord =
                        new ProducerRecord<>(KafkaConfig.getTopic(),"simpleMessage", msg);
                try {
                    producer.send(producerRecord).get();
                } catch (InterruptedException | ExecutionException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
    }
}

package com.example.observer.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Properties;

/**
 * @author Administrator
 */
public class KafkaConfig {

    static Properties properties;
    static String topic = "test-kafka";

    static {

        String groupId = "test_group5";

        properties = new Properties();
        //必须指定
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.145.132:9092");
        // 消费者必须指定
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        // 消费者必须指定
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        // 消费者必须指定
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        // 生产者必须指定
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG
                ,"org.apache.kafka.common.serialization.StringSerializer");
        // 生产者必须指定
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG
                , "org.apache.kafka.common.serialization.StringSerializer");

    }

    public static Properties getProperties(){
        return properties;
    }

    public static String getTopic(){
        return topic;
    }
}

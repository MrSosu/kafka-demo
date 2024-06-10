package com.example.kafka_demo.consumer;

import com.example.kafka_demo.entities.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    // @KafkaListener(topics = "sosu", groupId = "myGroup")
    public void consumeMessage(String message) {
        log.info(String.format("Messaggio consumato dal sosu topic: %s", message));
    }

    @KafkaListener(topics = "sosu", groupId = "myGroup")
    public void consumeJsonMessage(Student student) {
        log.info(String.format("Messaggio consumato dal sosu topic: %s", student.toString()));
    }


}

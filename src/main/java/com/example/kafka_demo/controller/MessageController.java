package com.example.kafka_demo.controller;

import com.example.kafka_demo.entities.Student;
import com.example.kafka_demo.producer.KafkaJsonProducer;
import com.example.kafka_demo.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;
    private KafkaJsonProducer kafkaJsonProducer;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
        return new ResponseEntity<>("messaggio messo in coda con successo", HttpStatus.OK);
    }

    @PostMapping("/send-json")
    public ResponseEntity<String> sendMessage(@RequestBody Student message) {
        kafkaJsonProducer.sendMessage(message);
        return new ResponseEntity<>("messaggio messo in coda con successo come JSON", HttpStatus.OK);
    }

}

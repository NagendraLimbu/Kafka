package com.nag.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/kafka")
public class MyController {

    @Autowired
    private KafkaTemplate<String, String> kt;

    private static final String MYTOPIC = "mytopic";

    @GetMapping("/topic/{message}")
    String getTest(@PathVariable("message") String message){
        kt.send(MYTOPIC, message);
        return message;
    }
}

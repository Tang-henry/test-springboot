package org.getech.henry.controller;

import org.getech.henry.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class MyController {

    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/process")
    public String process(@RequestParam String message) {
        try {
            // 发送Kafka消息并等待处理完成
            return kafkaService.sendMessage(message).get();
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            return "Error processing message";
        }
    }
}

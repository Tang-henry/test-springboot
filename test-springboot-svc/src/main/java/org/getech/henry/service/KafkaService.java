package org.getech.henry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class KafkaService {

    private static final String TOPIC = "my_topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final ConcurrentMap<String, CompletableFuture<String>> responseFutures = new ConcurrentHashMap<>();

    public CompletableFuture<String> sendMessage(String message) {
        CompletableFuture<String> future = new CompletableFuture<>();
        responseFutures.put(message, future);
        kafkaTemplate.send(TOPIC, message);
        return future;
    }

    @KafkaListener(topics = TOPIC, groupId = "group_id")
    public void listen(String message) {
        // Simulate processing and responding with the same message
        CompletableFuture<String> future = responseFutures.remove(message);
        if (future != null) {
            future.complete("Processed: " + message);
        }
    }
}

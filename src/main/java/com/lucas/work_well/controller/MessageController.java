package com.lucas.work_well.controller;

import com.lucas.work_well.mq.Producer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final Producer producer;

    public MessageController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping
    public ResponseEntity<String> send(@RequestBody String msg) {
        producer.sendMessage(msg);
        return ResponseEntity.ok("Mensagem enviada para RabbitMQ: " + msg);
    }
}

package com.lucas.work_well.mq;

import com.lucas.work_well.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String msg) {
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, msg);
        System.out.println("Mensagem enviada: " + msg);
    }
}

package com.lucas.work_well.mq;

import com.lucas.work_well.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void receiveMessage(String msg) {
        System.out.println("Mensagem recebida: " + msg);
    }
}

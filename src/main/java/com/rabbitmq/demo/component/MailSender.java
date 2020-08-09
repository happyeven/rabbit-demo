package com.rabbitmq.demo.component;

import com.rabbitmq.demo.entity.Mail;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author ZHUDO2
 * @Date 8/9/2020 2:24 PM
 * @Version 1.0
 */
@Component
public class MailSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Mail email) {
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(email.getId().toString());
        rabbitTemplate.convertAndSend("dong-test","mail.test",email,correlationData);
    }
}

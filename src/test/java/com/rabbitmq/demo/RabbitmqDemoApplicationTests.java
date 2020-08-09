package com.rabbitmq.demo;

import com.rabbitmq.demo.component.MailSender;
import com.rabbitmq.demo.entity.Mail;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqDemoApplicationTests {

    @Autowired
    private MailSender mailSender;

    @Test
    public void testSend() {
        Mail e = new Mail();
        e.setId(123456);
        e.setSubject("hello");
        e.setTo("dong.zhu@oocl.com");
        e.setContent("全军出击");
        mailSender.send(e);
    }
}

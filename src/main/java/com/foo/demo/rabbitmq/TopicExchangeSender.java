package com.foo.demo.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送者
 */
@Component
public class TopicExchangeSender {

    //RabbitTemplate是springBoot提供的默认实现
    @Autowired
    private RabbitTemplate rt;

    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.rt.convertAndSend("exchange", "topic.message", context);
    }

    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.rt.convertAndSend("exchange", "topic.messages", context);
    }
}

package com.foo.demo.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 发送者
 */
@Component
public class Sender {

    //RabbitTemplate是springBoot提供的默认实现
    @Autowired
    private RabbitTemplate rt;

    @Autowired
    private RabbitTemplate rt2;

    public void send(int i){
        String context1 = "hello " + i;
        String context2 = "hello2 " + i;
        System.out.println("Sender : " + context1);
        System.out.println("Sender : " + context2);
        this.rt.convertAndSend("hello", context1);
        this.rt2.convertAndSend("hello", context2);
    }
}

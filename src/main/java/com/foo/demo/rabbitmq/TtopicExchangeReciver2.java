package com.foo.demo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//消息监听器, queue需要与发送者的queue的name相同
@RabbitListener(queues = "topic.messages")
public class TtopicExchangeReciver2 {

    @RabbitHandler
    public void process(String hello){
        System.out.println("Reciver2:" + hello);
    }
}


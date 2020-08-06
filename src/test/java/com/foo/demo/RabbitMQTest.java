package com.foo.demo;

import com.foo.demo.rabbitmq.Sender;
import com.foo.demo.rabbitmq.TopicExchangeSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {

    @Autowired
    private Sender sender;

    @Autowired
    private TopicExchangeSender topicExchangeSender;

    @Test
    public void hello(){
//        sender.send();
    }

    @Test
    public void toMany(){
        for(int i = 0; i < 100; i++){
            sender.send(i);
        }
    }

    @Test
    public void topicExchangeTest(){
        for(int i = 0; i < 20; i++){
            topicExchangeSender.send2();
        }
    }
}

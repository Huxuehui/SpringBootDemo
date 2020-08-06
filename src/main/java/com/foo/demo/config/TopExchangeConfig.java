package com.foo.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//topic类型的交换机是RabbitMQ中最灵活的方式
@Configuration
public class TopExchangeConfig {

    final static String message = "topic.message";

    final static String messages = "topic.messages";

    @Bean
    public Queue queueMessage() {
        return new Queue(TopExchangeConfig.message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(TopExchangeConfig.messages);
    }

    //创建通配符交换机实例
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    //绑定发送消息1队列到交换机
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    //绑定发送消息2队列到交换机
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}

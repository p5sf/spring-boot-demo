package com.demo.listener;

import com.demo.config.RabbitMqConstant;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMqConstant.TOPIC_EXCHANGE_QUEUE_B))
public class TopicExchangeConsumerB {

    @RabbitHandler
    public void process(Map<String, Object> map) {
        System.out.println("topic队列B[" + RabbitMqConstant.TOPIC_EXCHANGE_QUEUE_B+ "]收到消息：" + map.toString());
    }
}

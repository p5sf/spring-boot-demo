package com.demo.listener;

import com.demo.config.RabbitMqConstant;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HeadersExchangeConsumerA {
    @RabbitListener(queuesToDeclare = @Queue(RabbitMqConstant.HEADERS_EXCHANGE_QUEUE_A))
    public void process(Message message) throws Exception {
        MessageProperties messageProperties = message.getMessageProperties();
        String contentType = messageProperties.getContentType();
        System.out.println("队列[" + RabbitMqConstant.HEADERS_EXCHANGE_QUEUE_A + "]收到消息：" + new String(message.getBody(), contentType));
    }
}

package com.demo.listener;

import com.demo.config.RabbitMqConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author YanZhao
 * @description
 * @date 2022年09月20日 22:36
 */

@Component
@RabbitListener(queues = {RabbitMqConstant.RABBITMQ_DEMO_TOPIC})
public class RabbitMQListener {

    @RabbitHandler
    public void send(Map map) {
        System.out.println("消费者接受消息"+ map.toString());
    }

}

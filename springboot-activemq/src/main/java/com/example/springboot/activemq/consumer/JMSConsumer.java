package com.example.springboot.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * JMS消息消费者
 */
@Component
public class JMSConsumer {


    @JmsListener(destination = "springboot.queue.test")
    public void receiveQueue(String message){
        System.out.println("从消息队列中获得的消息内容是：" + message);
    }



}

package com.example.springboot.activemq.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * JMS消息生产者
 */
@Component
public class JMSProducer {


    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;


    /**
     * 发送消息
     * @param destination
     * @param message
     */
    public void sendMessage(Destination destination, String message){
        jmsMessagingTemplate.convertAndSend(destination, message);
    }




}

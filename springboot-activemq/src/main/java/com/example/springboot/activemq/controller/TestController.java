package com.example.springboot.activemq.controller;

import com.example.springboot.activemq.producer.JMSProducer;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

@RequestMapping("/activemq")
@RestController
public class TestController {

    @Autowired
    private JMSProducer jmsProducer;

    @RequestMapping("/t1")
    private String test1(){

        Destination destination = new ActiveMQQueue("springboot.queue.test");

        jmsProducer.sendMessage(destination, "This message comes from JMSTest class!");
        return "test1";
    }


}

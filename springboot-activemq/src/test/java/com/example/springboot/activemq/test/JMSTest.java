package com.example.springboot.activemq.test;

import com.example.springboot.activemq.producer.JMSProducer;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JMSTest {

    @Autowired
    private JMSProducer jmsProducer;


    @Test
    public void testJMS(){

        Destination destination = new ActiveMQQueue("springboot.queue.test");

        jmsProducer.sendMessage(destination, "This message comes from JMSTest class!");

    }



}

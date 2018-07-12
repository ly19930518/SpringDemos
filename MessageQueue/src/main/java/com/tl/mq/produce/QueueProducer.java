package com.tl.mq.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Service("queueProducer")
public class QueueProducer {

    @Autowired
    @Qualifier("jmsQueueTemplate")
    private JmsTemplate jmsTemplate;

    public void send(String queueName,final String msg){
        System.out.println("xx");
        jmsTemplate.send(queueName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                System.out.println("创建消息");
                return session.createTextMessage(msg);
            }


        });
    }
}

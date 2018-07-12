package com.tl.mq.consumer;

import org.springframework.stereotype.Service;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.sql.SQLOutput;

@Service("mqConsumer1")
public class MQConsumer implements MessageListener {
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage)message;

        try{
            System.out.println("消费的QueueConsumer1获取消息:"+textMessage.getText());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

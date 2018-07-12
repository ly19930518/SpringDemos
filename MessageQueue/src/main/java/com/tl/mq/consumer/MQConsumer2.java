package com.tl.mq.consumer;

import org.springframework.stereotype.Service;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Service("mqConsumer2")
public class MQConsumer2 implements MessageListener {
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage)message;
        try{
            System.out.println("消费的QueueConsumer2获取消息:"+textMessage.getText());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

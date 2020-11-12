package com.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

public class Producer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("testMq");
        producer.setNamesrvAddr("192.168.124.5:9876");
        producer.start();

        Message msg = new Message("myTopic001", "xxxxooo 第1条".getBytes());
        SendResult sendResult3 = producer.send(msg);

        System.out.println(sendResult3);
        producer.shutdown();
        System.out.println("已经停机");
    }
}

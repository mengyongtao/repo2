package com.myt.test;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsProduce {
	private static final String ACTIVEMQ_URL = "tcp://192.168.0.101:61616";
	private static final String QUEUE_NAME = "queue01";
	
	public static void main(String[] args) throws JMSException {
		//创建连接工厂，按照给定的URL地址，采用默认的用户名和密码
//		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
		//访问连接工厂，获得连接connection并启动访问
//		Connection connection = factory.createConnection();
//		connection.start();
		//创建会话session
		//两个参数，第一个参数叫事务，第二个叫签收
//		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//创建目的地(具体是队列queue还是主题topic)
//		Queue queue = session.createQueue(QUEUE_NAME);
		//创建消息生产者
//		MessageProducer messageProducer = session.createProducer(queue);
		//通过使用messageProducer生产3条消息发送到MQ的队列里面
//		for(int i = 0; i < 3; i++) {
			//创建消息
//			TextMessage textMessage = session.createTextMessage("msg---"+i);
			//通过messageProducer发送给MQ
//			messageProducer.send(textMessage);
		}
		//关闭资源
//		messageProducer.close();
//		session.close();
//		connection.close();
//		System.out.println("****消息发送到MQ完成");
		
		
		
		
}


package com.myt.test;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsConsumer {
	private static final String ACTIVEMQ_URL = "tcp://192.168.0.101:61616";
	private static final String QUEUE_NAME = "queue01";
	
	public static void main(String[] args) throws JMSException, IOException {
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
		//创建消费者
//		MessageConsumer consumer = session.createConsumer(queue);
		//同步阻塞方式(receive())
//		while(true) {
//			TextMessage message = (TextMessage) consumer.receive();
//			if(message != null) {
//				System.out.println("***接收消息:"+message.getText());
//			}else {
//				break;
//			}
//		}
		//异步非阻塞方式(监听器onMessage())
		//通过监听的方式来消费消息 
//		consumer.setMessageListener(new MessageListener() {
//			
//			@Override
//			public void onMessage(Message message) {
//				if(null != message && message instanceof TextMessage) {
//					TextMessage textMessage = (TextMessage) message;
//					try {
//						System.out.println(consumer+"消费者接收到消息："+textMessage.getText());
//					} catch (JMSException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				
//			}
//		});
//		System.in.read();
//		//关闭资源
//		consumer.close();
//		session.close();
//		connection.close();
	}	
}

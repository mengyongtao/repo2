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
		//�������ӹ��������ո�����URL��ַ������Ĭ�ϵ��û���������
//		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
		//�������ӹ������������connection����������
//		Connection connection = factory.createConnection();
//		connection.start();
		//�����Ựsession
		//������������һ�����������񣬵ڶ�����ǩ��
//		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//����Ŀ�ĵ�(�����Ƕ���queue��������topic)
//		Queue queue = session.createQueue(QUEUE_NAME);
		//����������
//		MessageConsumer consumer = session.createConsumer(queue);
		//ͬ��������ʽ(receive())
//		while(true) {
//			TextMessage message = (TextMessage) consumer.receive();
//			if(message != null) {
//				System.out.println("***������Ϣ:"+message.getText());
//			}else {
//				break;
//			}
//		}
		//�첽��������ʽ(������onMessage())
		//ͨ�������ķ�ʽ��������Ϣ 
//		consumer.setMessageListener(new MessageListener() {
//			
//			@Override
//			public void onMessage(Message message) {
//				if(null != message && message instanceof TextMessage) {
//					TextMessage textMessage = (TextMessage) message;
//					try {
//						System.out.println(consumer+"�����߽��յ���Ϣ��"+textMessage.getText());
//					} catch (JMSException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				
//			}
//		});
//		System.in.read();
//		//�ر���Դ
//		consumer.close();
//		session.close();
//		connection.close();
	}	
}

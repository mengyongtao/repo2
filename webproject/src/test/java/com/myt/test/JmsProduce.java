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
		//������Ϣ������
//		MessageProducer messageProducer = session.createProducer(queue);
		//ͨ��ʹ��messageProducer����3����Ϣ���͵�MQ�Ķ�������
//		for(int i = 0; i < 3; i++) {
			//������Ϣ
//			TextMessage textMessage = session.createTextMessage("msg---"+i);
			//ͨ��messageProducer���͸�MQ
//			messageProducer.send(textMessage);
		}
		//�ر���Դ
//		messageProducer.close();
//		session.close();
//		connection.close();
//		System.out.println("****��Ϣ���͵�MQ���");
		
		
		
		
}


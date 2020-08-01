package com.myt.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.EverythingMatcher;
import org.quartz.impl.matchers.KeyMatcher;

public class TestQuartz {
	public static void main(String[] args) throws SchedulerException, InterruptedException {
		// 1.������ (scheduler),�ӹ�����ȡ����ʵ��
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		// 2.����ʵ��(JobDetail)
		JobDetail jobDetail = JobBuilder.newJob(Myjob.class) // ���������࣬��Myjob��ɰ�
				.withIdentity("job1", "group1") // �������ƣ�����������
				.usingJobData("data01", "hello")
				.usingJobData("count", 0)
				.build();
		// ����һ��Trigger,������������Trigger
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("trigger1", "group1")// ���������ƣ�������������
				.startNow() // ��������������
//				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(10)) //2sһ�Σ��ظ�10��
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatSecondlyForever(5))//ÿ5s�ظ�ִ��һ��
//				.endAt(new GregorianCalendar(2020,6,18,23,38,0).getTime())
//				.withSchedule(CronScheduleBuilder.cronSchedule("0 51 16 * * ?"))
				.build();
		// ��������������ʹ���������֤���մ��������������ִ������
		scheduler.scheduleJob(jobDetail, trigger);
		//ȫ��JobListener
//		scheduler.getListenerManager().addJobListener(new MyJobListener(),EverythingMatcher.allJobs());
		//�ֲ�JobListener
//		scheduler.getListenerManager().addJobListener(new MyJobListener(),KeyMatcher.keyEquals(JobKey.jobKey("job1", "group1")));
		//ȫ��TriggerListener
		scheduler.getListenerManager().addTriggerListener(new MyTriggerListener(),EverythingMatcher.allTriggers());
		//�ֲ�TriggerListener
		scheduler.getListenerManager().addTriggerListener(new MyTriggerListener(),KeyMatcher.keyEquals(TriggerKey.triggerKey("trigger1", "group1")));
		// ����������
		scheduler.start();
		// �رյ�����
		Thread.sleep(200000);
		scheduler.shutdown();

	}

}

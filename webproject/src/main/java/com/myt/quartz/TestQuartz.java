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
		// 1.调度器 (scheduler),从工厂获取调度实例
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		// 2.任务实例(JobDetail)
		JobDetail jobDetail = JobBuilder.newJob(Myjob.class) // 加载任务类，与Myjob完成绑定
				.withIdentity("job1", "group1") // 任务名称，任务组名称
				.usingJobData("data01", "hello")
				.usingJobData("count", 0)
				.build();
		// 定义一个Trigger,创建触发器：Trigger
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("trigger1", "group1")// 触发器名称，触发器组名称
				.startNow() // 马上启动触发器
//				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(10)) //2s一次，重复10次
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatSecondlyForever(5))//每5s重复执行一次
//				.endAt(new GregorianCalendar(2020,6,18,23,38,0).getTime())
//				.withSchedule(CronScheduleBuilder.cronSchedule("0 51 16 * * ?"))
				.build();
		// 调度器关联任务和触发器，保证按照触发器定义的条件执行任务
		scheduler.scheduleJob(jobDetail, trigger);
		//全局JobListener
//		scheduler.getListenerManager().addJobListener(new MyJobListener(),EverythingMatcher.allJobs());
		//局部JobListener
//		scheduler.getListenerManager().addJobListener(new MyJobListener(),KeyMatcher.keyEquals(JobKey.jobKey("job1", "group1")));
		//全局TriggerListener
		scheduler.getListenerManager().addTriggerListener(new MyTriggerListener(),EverythingMatcher.allTriggers());
		//局部TriggerListener
		scheduler.getListenerManager().addTriggerListener(new MyTriggerListener(),KeyMatcher.keyEquals(TriggerKey.triggerKey("trigger1", "group1")));
		// 启动调度器
		scheduler.start();
		// 关闭调度器
		Thread.sleep(200000);
		scheduler.shutdown();

	}

}

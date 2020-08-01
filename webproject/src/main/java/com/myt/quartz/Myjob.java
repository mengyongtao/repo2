package com.myt.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
@PersistJobDataAfterExecution
public class Myjob implements Job{
	private int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// 创建工作详情
		JobDetail jobDetail = context.getJobDetail();
		//获取工作的名称
		String name = jobDetail.getKey().getName();//任务名
		String group = jobDetail.getKey().getGroup();//任务组
		String className = jobDetail.getJobClass().getName();//任务类 
		String job = jobDetail.getJobDataMap().getString("data01");//任务中的数据
		String dat = context.getTrigger().getJobDataMap().getString("key");
		System.out.println("job执行，job名："+name+"   group:"+group+"  data:"+job+new Date()+"    任务类："+className);
		
	}

}

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
		// ������������
		JobDetail jobDetail = context.getJobDetail();
		//��ȡ����������
		String name = jobDetail.getKey().getName();//������
		String group = jobDetail.getKey().getGroup();//������
		String className = jobDetail.getJobClass().getName();//������ 
		String job = jobDetail.getJobDataMap().getString("data01");//�����е�����
		String dat = context.getTrigger().getJobDataMap().getString("key");
		System.out.println("jobִ�У�job����"+name+"   group:"+group+"  data:"+job+new Date()+"    �����ࣺ"+className);
		
	}

}

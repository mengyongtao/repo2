package com.myt.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class MyJobListener implements JobListener{

	@Override
	public String getName() {
		String name = getClass().getSimpleName();
		return name;
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		// TODO Auto-generated method stub
		System.out.println("将要。。。");
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		// TODO Auto-generated method stub
		System.out.println("监听器。。。");
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		// TODO Auto-generated method stub
		System.out.println("执行后。。。");
	}

	

}

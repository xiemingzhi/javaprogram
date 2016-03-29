package com.mycompany;

import java.io.IOException;
import java.util.Properties;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BizRuleSet implements Job {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public BizRuleSet() {
	}

	@Override
	public void execute(JobExecutionContext jobContext)
			throws JobExecutionException {
		JobKey jobKey = jobContext.getJobDetail().getKey();

		JobDataMap dataMap = jobContext.getJobDetail().getJobDataMap();
		String jobParamList = dataMap.getString("jobParam"); // can define here any kind of format you want for example comma separated list of commands etc.

		// define here what to do when you see a command you understand
		logger.debug("I am a job you have passed me these parameters " + jobParamList);
		// throw JobExecutionException if it is something you don't understand
	}

}

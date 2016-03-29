package com.mycompany;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.CronScheduleBuilder.*;

public class BatchRules {
	String jobName, jobGroup, jobParam;

	public BatchRules(String jobName, String jobGroup, String jobParam) {
		this.jobName = jobName;
		this.jobGroup = jobGroup;
		this.jobParam = jobParam; // data to pass to the job
	}

	public void batchJob(Scheduler myScheduler, int timeElapse) {
		try {
			JobDetail myJob = newJob(BizRuleSet.class)
					.withIdentity(this.jobName, this.jobGroup)
					.usingJobData("jobParam", this.jobParam).build();

			String triggerScript = String.format("0/%d * * * * ?", timeElapse);
			Trigger myTrigger = newTrigger()
					.withIdentity(this.jobName, this.jobGroup)
					.withSchedule(cronSchedule(triggerScript)).build();

			myScheduler.scheduleJob(myJob, myTrigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}

package com.mycompany;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShutdownScheduler extends Thread {
	private Scheduler myScheduler = null;
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public ShutdownScheduler(Scheduler myScheduler) {
		this.myScheduler = myScheduler;
	}

	public void run() {
		try {
			logger.warn("Job Scheduler Finished!");
			myScheduler.shutdown(true);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}

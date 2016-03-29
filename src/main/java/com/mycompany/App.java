package com.mycompany;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Starting the scheduler" );
		int WAIT_SECONDS = 30; // let the main thread sleep, also how long before starting the job
		String jobParams = "sayhello";
		BatchRules myBatchRules = new BatchRules("job1", "jobGroup1", jobParams);

		try {
			Scheduler myScheduler = StdSchedulerFactory.getDefaultScheduler();

			Runtime.getRuntime().addShutdownHook(
					new ShutdownScheduler(myScheduler));

			myScheduler.start();
			myBatchRules.batchJob(myScheduler, WAIT_SECONDS);

			for (; !myScheduler.isShutdown();) {
				Thread.sleep(WAIT_SECONDS * 1000L);
			}

			myScheduler = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		myBatchRules = null;		
		System.out.println( "Ending the scheduler" );
    }
}

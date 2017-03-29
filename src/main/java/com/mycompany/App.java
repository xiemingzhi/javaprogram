package com.mycompany;

import org.apache.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final Logger log = Logger.getLogger(App.class);
	
    public static void main( String[] args )
    {
    	log.debug("inside main");
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
    	try {
    		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
    		Destination destination = (Destination) context.getBean("messageDestination");

    		TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);		
			System.out.println("Consumer receives " + textMessage.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			context.close();
		}
    }
}

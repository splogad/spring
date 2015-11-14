package com.splogad.myapp.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("MockEmailSender2")
public class MockEmailSender2 implements EmailSender {
	
	@Value("${com.splogad.admin}")
	private String name;
	
	private static final Logger logger = LoggerFactory.getLogger(MockEmailSender2.class); 
	
	/* (non-Javadoc)
	 * @see com.splogad.myapp.email.EmailSender#send(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void send(String to, String subject, String body){
		logger.info("Sending email to: "+to+" from:"+name);
		logger.info("Subject: "+subject);
		logger.info("Body: "+body);
		logger.info("Receiving ACK....");
		logger.info("ACK received!");
		
	}
}

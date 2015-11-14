package com.splogad.myapp.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
//@Component("MockEmailSender")
public class MockEmailSender implements EmailSender {
	
	private static final Logger logger = LoggerFactory.getLogger(MockEmailSender.class); 
	
	/* (non-Javadoc)
	 * @see com.splogad.myapp.email.EmailSender#send(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void send(String to, String subject, String body){
		logger.info("Sending email to: "+to);
		logger.info("Subject: "+subject);
		logger.info("Body: "+body);
	}
}

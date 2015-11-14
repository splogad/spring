package com.splogad.myapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.splogad.myapp.email.*;

@Configuration
public class EmailConfig {

	@Bean
	@Profile("!dev")
	public EmailSender MockEmailSender() {
		return new MockEmailSender();
	}
	
	@Bean
	@Profile("dev")
	public EmailSender MockEmailSender2() {
		return new MockEmailSender2();
	}
}

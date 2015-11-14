package com.splogad.myapp.email;

public interface EmailSender {

	void send(String to, String subject, String body);

}
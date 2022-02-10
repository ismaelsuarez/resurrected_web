package com.resurrected.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailNotifications {

	@Autowired
	private JavaMailSender mailSender;
	
	
	@Async
	public void sendEmail(String body,String title,String email ) {
		
		SimpleMailMessage message =new SimpleMailMessage();
		
		message.setTo(email);
		message.setFrom("noreply@pizzapp.com");
		message.setSubject(title);
		message.setText(body);
		message.setSentDate(new Date());		
		mailSender.send(message);
	}
}

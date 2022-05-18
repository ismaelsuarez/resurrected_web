package com.resurrected.service;

import java.util.Date;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailNotifications {

	private final JavaMailSender mailSender;

	public EmailNotifications(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

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

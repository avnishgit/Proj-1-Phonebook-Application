package com.ag.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	 @Autowired
     private JavaMailSender emailSender;
	 
	public void sendEmail(String to) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(to);
		message.setFrom("avnish84048@gmail.com");
		message.setSubject("wish message");
		message.setText("HI Ashish How r u");
		emailSender.send(message);
		
	}
}

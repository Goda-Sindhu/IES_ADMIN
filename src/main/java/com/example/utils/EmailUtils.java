package com.example.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {
	@Autowired
	private JavaMailSender mailsender;

	public boolean sendEmail(String subject, String body, String to) {
		try {
			MimeMessage mimemsg = mailsender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(mimemsg);
			helper.setSubject(subject);
			helper.setText(body, true);
			helper.setTo(to);
			//helper.addAttachment("Plans-Info", f);
			mailsender.send(mimemsg);

		} catch (Exception e) {
			System.out.println(e);
		}
		return true;
	
	}
	
}

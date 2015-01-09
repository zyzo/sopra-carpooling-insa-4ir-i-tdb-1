package com.sopride.web.util;

import com.sopride.web.controller.UserCtrl;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class WebUtils {

	public static void forward(ServletRequest req, ServletResponse resp, String jspPage)
			throws ServletException, IOException {
		req.getServletContext()
		.getRequestDispatcher("/WEB-INF/jsp/" + jspPage)
		.forward(req,resp);
	}

	public static UserCtrl getUserCtrl(ServletRequest req) {
		HttpServletRequest request = (HttpServletRequest) req;
		return (UserCtrl) request.getSession().getAttribute(WebConstants.SESSION_USER_CTRL);
	}

	public static void sendMail(String to,String subject,String content){

		// Sender's email ID 
		String from = "soprideshare@gmail.com";
		final String username = "soprideshare@gmail.com";
		final String password = "carpooling";

		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "25");

		// Get the Session object.
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject(subject);

			// Now set the actual message
			message.setText(content);

			// Send message
			Transport.send(message);

			//System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	
	public static void sendMailHTML(String to,String subject,String content){

		// Sender's email ID 
		String from = "soprideshare@gmail.com";
		final String username = "soprideshare@gmail.com";
		final String password = "carpooling";

		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "25");

		// Get the Session object.
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject(subject);

			// Now set the actual message
			message.setContent(content, "text/html");

			// Send message
			Transport.send(message);

			//System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
}


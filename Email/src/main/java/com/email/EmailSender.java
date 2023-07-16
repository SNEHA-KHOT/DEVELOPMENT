package com.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmailSender {
	
	 public static void main(String[] args) {

	        String message ="HELLO WELCOME  !!!!!!!";
	         String subject ="MAIL CONFIRMATION ";
	       // String from="snehavkhot3296@gmail.com";
	        // String from="sneha.vk@dikshatech.com";
	        String to ="sneha.vk@dikshatech.com";

	        System.out.println("EMAIL GENERATING ..........");

	        sendEmail(message,subject,to/*,from*/);

//	        sendEmailAttachment(message,subject,to,from);
	   }
	    private static void sendEmail(String message, String subject, String to/*, String from*/) {

	        //host
	       // String host = "smtp.gmail.com";
	    	String host = "email-smtp.us-east-1.amazonaws.com";
	    	
	        //properties
	        Properties properties = System.getProperties();

	        properties.put("mail.smtp.host",host);
	       // properties.put("mail.smtp.port","465");
	        properties.put("mail.smtp.port","587");
	       // properties.put("mail.smtp.ssl.enable","true");
	        properties.put("mail.smtp.auth","true");
	        properties.put("mail.smtp.starttls.enable","true");
	        properties.put("mail.smtp.starttls.required","true");

	        //session object
	        Session session = Session.getInstance(properties, new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	              
	            	//return new PasswordAuthentication("sdikshatitan123@gmail.com","setrlqggybhrdwzw");
	            	return new PasswordAuthentication("AKIA4CM3UMKYC2HKPHTL","BBH9e53mYKZyHAWn3X1T6y7COCVK71ID4M/vApe4bWY6");
	            }
	        });


	        session.setDebug(true);

	        MimeMessage mm = new MimeMessage(session);

	        try{

	           // mm.setFrom(from);

	            mm.setSubject(subject);

	            mm.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

	            mm.setText(message);
	            Transport.send(mm);

	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }

	        System.out.println("EMAIL SENT SUCCESSFULLY ..........."+to);

	    }}
	 


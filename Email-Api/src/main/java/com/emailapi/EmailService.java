package com.emailapi;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	
public boolean sendEmailwithAttachments(EmailAttachmentsDto req) {
		
		boolean flag=false;
		 //host
		// String host = "smtp.gmail.com";
    	String host = "email-smtp.us-east-1.amazonaws.com";

        //properties
        Properties properties = System.getProperties();

        properties.put("mail.smtp.host",host);
        // properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");


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
        	
            mm.setFrom(req.getFrom());

            mm.setSubject(req.getSubject());

            mm.addRecipient(Message.RecipientType.TO,new InternetAddress(req.getTo()));

           // mm.setText(message);
            //String filePath= "C:\\Users\\diksha\\Downloads\\generate.pdf";
            //String filePath="C:\\Users\\diksha\\OneDrive\\Pictures\\Screenshots\\OrderStatus.png";
            MimeMultipart mimeMultipart= new MimeMultipart();
            MimeBodyPart textm= new  MimeBodyPart();
            MimeBodyPart filem= new  MimeBodyPart();
            List<Object> list = new ArrayList<Object>();
            
            try {
            	textm.setText(req.getMessage());
            	mimeMultipart.addBodyPart(textm);
            	for(AttachmentDto a:req.getAttachments()) {
            		File f= new File(a.getAlink());
                	filem.attachFile(f);
                	boolean obj=list.add(filem);
                	mimeMultipart.addBodyPart(filem);
                	
            	}
            	
            	
            	mimeMultipart.addBodyPart((BodyPart) list);
            	//mimeMultipart.addBodyPart(filem);
            }catch (Exception e){
                e.printStackTrace();
            }
            
            mm.setContent(mimeMultipart);
            Transport.send(mm);

        }
        catch (Exception e){
            e.printStackTrace();
        }

        
        System.out.println("EMAIL AttachmentSENT SUCCESSFULLY...........");
        flag=true;;
        return flag;
		
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean sendEmail(EmailReqDto req) {
		
		boolean flag=false;
		 //host
        String host = "smtp.gmail.com";

        //properties
        Properties properties = System.getProperties();

        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");


        //session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
              
            	return new PasswordAuthentication("username","password");
            }
        });


        session.setDebug(true);

        MimeMessage mm = new MimeMessage(session);

        try{
        	
            mm.setFrom(req.getFrom());

            mm.setSubject(req.getSubject());

            mm.addRecipient(Message.RecipientType.TO,new InternetAddress(req.getTo()));

           // mm.setText(message);
            String filePath= "C:\\Users\\diksha\\Downloads\\generate.pdf";
            //String filePath="C:\\Users\\diksha\\OneDrive\\Pictures\\Screenshots\\OrderStatus.png";
            MimeMultipart mimeMultipart= new MimeMultipart();
            MimeBodyPart textm= new  MimeBodyPart();
            MimeBodyPart filem= new  MimeBodyPart();
            
            try {
            	textm.setText(req.getMessage());
            	if(req.getAlink() != null  ) {
            	File f= new File(req.getAlink());
            	filem.attachFile(f);
            	mimeMultipart.addBodyPart(filem);
            	}
            	mimeMultipart.addBodyPart(textm);
            	
            }catch (Exception e){
                e.printStackTrace();
            }
            
            mm.setContent(mimeMultipart);
            Transport.send(mm);

        }
        catch (Exception e){
            e.printStackTrace();
        }

        
        System.out.println("EMAIL AttachmentSENT SUCCESSFULLY...........");
        flag=true;;
        return flag;
		
	}


	public boolean sendEmails(List<EmailReqDto> req) {
		// TODO Auto-generated method stub
		return false;
	}
		
	
	
	
	
	}



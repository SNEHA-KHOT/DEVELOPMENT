package com.email;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailAttachment {

	
	 public static void main(String[] args) {

	        String message ="HELLO WELCOME EA !!!!!!!";
	         String subject ="MAIL Attachment ";
	      
	         String from="sdikshatitan123@gmail.com";
	        String to ="sdikshatitan123@gmail.com";

	        System.out.println("EMAIL GENERATING ..........");

	     
        sendEmailAttachment(message,subject,to,from);
	   }

	private static void sendEmailAttachment(String message, String subject, String to, String from) {
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
              
            	return new PasswordAuthentication("sdikshatitan123@gmail.com","setrlqggybhrdwzw");
            }
        });


        session.setDebug(true);

        MimeMessage mm = new MimeMessage(session);

        try{
        	
            mm.setFrom(from);

            mm.setSubject(subject);

            mm.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

           // mm.setText(message);
            String filePath= "C:\\Users\\diksha\\Downloads\\generate.pdf";
            //String filePath="C:\\Users\\diksha\\OneDrive\\Pictures\\Screenshots\\OrderStatus.png";
            MimeMultipart mimeMultipart= new MimeMultipart();
            MimeBodyPart textm= new  MimeBodyPart();
            MimeBodyPart filem= new  MimeBodyPart();
            
            try {
            	textm.setText(message);
            	File f= new File(filePath);
            	filem.attachFile(f);
            	mimeMultipart.addBodyPart(textm);
            	mimeMultipart.addBodyPart(filem);
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

		
	}
}

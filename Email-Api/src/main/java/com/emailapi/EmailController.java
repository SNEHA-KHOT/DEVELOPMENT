package com.emailapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailService ;
	
	@PostMapping("/sendEmail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailReqDto req) {
		boolean flag=emailService.sendEmail(req);
		if(flag==true) {return new ResponseEntity<>("email sent succesfully ", HttpStatus.OK);}
		else {return new ResponseEntity<>("sending enmail failed..", HttpStatus.BAD_REQUEST);}
	}

	
	
	@PostMapping("/sendEmailwithAttachments")
	public ResponseEntity<?> sendEmailwithAttachments(@RequestBody EmailAttachmentsDto req) {
		boolean flag=emailService.sendEmailwithAttachments(req);
		if(flag==true) {return new ResponseEntity<>("email sent succesfully ", HttpStatus.OK);}
		else {return new ResponseEntity<>("sending enmail failed..", HttpStatus.BAD_REQUEST);}
	}
	
	@PostMapping("/sendEmails")
	public ResponseEntity<?> sendEmails(@RequestBody List<EmailReqDto> req) {
		boolean flag=emailService.sendEmails(req);
		if(flag==true) {return new ResponseEntity<>("email sent succesfully ", HttpStatus.OK);}
		else {return new ResponseEntity<>("sending enmail failed..", HttpStatus.BAD_REQUEST);}
	}
	
	
}

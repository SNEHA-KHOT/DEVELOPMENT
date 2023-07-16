package com.emailapi;

import java.util.List;

public class EmailAttachmentsDto {
	private String message ;
	private String subject ;
	private String from;
	private String to ;
	private List<AttachmentDto> attachments;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public List<AttachmentDto> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<AttachmentDto> attachments) {
		this.attachments = attachments;
	}
	
	@Override
	public String toString() {
		return "EmailReqDto [message=" + message + ", subject=" + subject + ", from=" + from + ", to=" + to
				+ ", attachments=" + attachments + "]";
	}
	
	/*public String getAlink() {
		return alink;
	}
	public void setAlink(String alink) {
		this.alink = alink;
	}
	@Override
	public String toString() {
		return "EmailReqDto [message=" + message + ", subject=" + subject + ", from=" + from + ", to=" + to + ", alink="
				+ alink + "]";
	}*/
	
}

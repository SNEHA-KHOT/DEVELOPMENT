package com.diksha.pdf;

import java.util.List;

import com.itextpdf.layout.element.IBlockElement;

public class PdfReqDto {
	
	private String bookingDate;
	private long orderId;
	private long ticketId;
	private String ticketClass;
	private String eventName;
	private String eventDate;
	private String eventTime;
	private String eventLocation;
	private String eventImgUrl;
	private List<TicketSubclassDto> ticketSubclasses;
	private List<AmountDto> amountList;
	

	public PdfReqDto() {
		super();
		
	}


	public long getOrderId() {
		return orderId;
	}


	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


	public String getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}


	public long getTicketId() {
		return ticketId;
	}


	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}


	public String getTicketClass() {
		return ticketClass;
	}


	public void setTicketClass(String ticketClass) {
		this.ticketClass = ticketClass;
	}


	public String getEventImgUrl() {
		return eventImgUrl;
	}


	public void setEventImgUrl(String eventImgUrl) {
		this.eventImgUrl = eventImgUrl;
	}


	public String getEventName() {
		return eventName;
	}


	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


	public String getEventDate() {
		return eventDate;
	}


	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}


	public String getEventTime() {
		return eventTime;
	}


	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}


	public String getEventLocation() {
		return eventLocation;
	}


	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}


	public List<TicketSubclassDto> getTicketSubclasses() {
		return ticketSubclasses;
	}


	public void setTicketSubclasses(List<TicketSubclassDto> ticketSubclasses) {
		this.ticketSubclasses = ticketSubclasses;
	}


	public List<AmountDto> getAmountList() {
		return amountList;
	}


	public void setAmountList(List<AmountDto> amountList) {
		this.amountList = amountList;
	}


	@Override
	public String toString() {
		return "PdfReqDto [bookingDate=" + bookingDate + ", orderId=" + orderId + ", ticketId=" + ticketId
				+ ", ticketClass=" + ticketClass + ", eventName=" + eventName + ", eventDate=" + eventDate
				+ ", eventTime=" + eventTime + ", eventLocation=" + eventLocation + ", eventImgUrl=" + eventImgUrl
				+ ", ticketSubclasses=" + ticketSubclasses + ", amountList=" + amountList + "]";
	}


	
	}


	


	

	

	
	
	



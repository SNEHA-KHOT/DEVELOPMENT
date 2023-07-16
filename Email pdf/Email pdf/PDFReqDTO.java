package com.diksha.titan.mail.services;

public class PDFReqDTO {
	
	private String orderId;
	private String bookingDate;
	private String ticketId;
	private String ticketClass;
	private String qrImage;
	private String eventName;
	private String eventDate;
	private String eventTime;
	private String eventVenue;
	private String eventImage;
	private Double finalTotal;
	private String quantity;
	private String ticketName;
	private Double ticketAmount;
	private Double total;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Double getFinalTotal() {
		return finalTotal;
	}
	public void setFinalTotal(Double finalTotal) {
		this.finalTotal = finalTotal;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getTicketClass() {
		return ticketClass;
	}
	public void setTicketClass(String ticketClass) {
		this.ticketClass = ticketClass;
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
	public String getEventVenue() {
		return eventVenue;
	}
	public void setEventVenue(String eventVenue) {
		this.eventVenue = eventVenue;
	}
	
	public String getQrImage() {
		return qrImage;
	}
	public void setQrImage(String qrImage) {
		this.qrImage = qrImage;
	}
	public String getEventImage() {
		return eventImage;
	}
	public void setEventImage(String eventImage) {
		this.eventImage = eventImage;
	}
	
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getTicketName() {
		return ticketName;
	}
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	public Double getTicketAmount() {
		return ticketAmount;
	}
	public void setTicketAmount(Double ticketAmount) {
		this.ticketAmount = ticketAmount;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public PDFReqDTO(String orderId, String bookingDate, String ticketId, String ticketClass, String qrImage,
			String eventName, String eventDate, String eventTime, String eventVenue, String eventImage,
			 Double finalTotal) {
		super();
		this.orderId = orderId;
		this.bookingDate = bookingDate;
		this.ticketId = ticketId;
		this.ticketClass = ticketClass;
		this.qrImage = qrImage;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.eventVenue = eventVenue;
		this.eventImage = eventImage;
		this.finalTotal = finalTotal;
	}
	
	@Override
	public String toString() {
		return "PDFReqDTO [orderId=" + orderId + ", bookingDate=" + bookingDate + ", ticketId=" + ticketId
				+ ", ticketClass=" + ticketClass + ", qrImage=" + qrImage + ", eventName=" + eventName + ", eventDate="
				+ eventDate + ", eventTime=" + eventTime + ", eventVenue=" + eventVenue + ", eventImage=" + eventImage
				+ ", finalTotal=" + finalTotal + ", quantity=" + quantity + ", ticketName=" + ticketName
				+ ", ticketAmount=" + ticketAmount + ", total=" + total + "]";
	}
	
	

}

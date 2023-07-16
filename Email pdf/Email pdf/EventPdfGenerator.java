package com.diksha.titan.mail.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.diksha.titan.exceptions.QRCodeException;
import com.diksha.titan.services.dao.model.TitanOrdersEventTickets;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.io.font.FontConstants;

@Component
public class EventPdfGenerator {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EventQRCodeService eventQRCodeService;
	
	public ByteArrayInputStream generatePDF(PDFReqDTO reqDto,String language) throws QRCodeException, IOException {
		
//		PDFReqDTO reqDto = null; //ticket.getTitanEventVenueTicketSubClass().getTitanEventVenueTicketClass().getTitanEventVenues().getTitanEvents()
		logger.info("Create PDF started");
		String bookingDate;String orderID;String ticketID;String ticketClass;String eventDet;

		DateFormat dateformat = new SimpleDateFormat("MMM dd yyyy");
		DateFormat timeformat = new SimpleDateFormat("hh:mm a");
		
		PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
		PdfFont bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);

		// qr code
		byte[] qrcode = eventQRCodeService.generateTicketQRCode(String.valueOf(reqDto.getTicketId()));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PdfDocument pdfDoc;
		pdfDoc = new PdfDocument(new PdfWriter(out));
		Document document = new Document(pdfDoc, PageSize.A4);
		
		try
		{
			String filename =  "classpath:/images/LOGO.png";
			ImageData imageData = ImageDataFactory.create(filename);
			Image pdfImg = new Image(imageData);
			pdfImg.scaleAbsolute(90f, 25f);
			pdfImg.setHorizontalAlignment(HorizontalAlignment.CENTER);
//			document.add(pdfImg);
		    
		    ImageData qrImgDate = ImageDataFactory.create(qrcode);
			Image qrImg = new Image(qrImgDate);
			qrImg.scaleAbsolute(170f, 170f);
			qrImg.setHorizontalAlignment(HorizontalAlignment.RIGHT);
//			qrImg.setHeight(230);
//			qrImg.setWidth(230);
//			qrImg.setMarginLeft(235).setMarginTop(10);
//			document.add(qrImg);
			
			//Adding Table Data
			
			//Nested Table - Events
			float columWidthNested[]= {20,150};
			Table tableNested = new Table(columWidthNested);
			String calenda = "classpath:/images/event_date.png";// "C:/Users/Diksha/Downloads/calendar.png";
			ImageData calendar = ImageDataFactory.create(calenda);
			Image calendarr = new Image(calendar);
			tableNested.addCell(new Cell().add(calendarr).setBorder(Border.NO_BORDER).setPadding(5));
			tableNested.addCell(new Cell().add(reqDto.getEventDate()).setBorder(Border.NO_BORDER).setPadding(5)); //"May 30 2023"
			
			float columWidthNested1[]= {20,150};
			Table tableNested1 = new Table(columWidthNested1);
			String clock =   "classpath:/images/event_timing.png"; // "C:/Users/Diksha/Downloads/clock.png";
			ImageData cloc = ImageDataFactory.create(clock);
			Image clo = new Image(cloc);
			tableNested1.addCell(new Cell().add(clo).setBorder(Border.NO_BORDER).setPadding(5));
			tableNested1.addCell(new Cell().add(reqDto.getEventTime()).setBorder(Border.NO_BORDER).setPadding(5));
			
			float columWidthNested2[]= {20,250};
			Table tableNested2 = new Table(columWidthNested2);
			String location =  "classpath:/images/event_location.png";
			ImageData locati = ImageDataFactory.create(location);
			Image locat = new Image(locati);
			tableNested2.addCell(new Cell().add(locat).setBorder(Border.NO_BORDER).setPadding(5));
			tableNested2.addCell(new Cell().add(reqDto.getEventVenue()).setBorder(Border.NO_BORDER).setPadding(5));	//"Caya Dr.J.E.M. Arends 18, \n"+"Oranjestad Aruba"
			
			float columWidthNested3[]= {20,230};
			Table tableNested3= new Table(columWidthNested3);
			String tickett =  "classpath:/images/event_tickets.png";
			ImageData ticke = ImageDataFactory.create(tickett);
			Image tickk = new Image(ticke);
//			tickk.scaleAbsolute(15f, 15f);
			tableNested3.addCell(new Cell().add(tickk).setBorder(Border.NO_BORDER));
			tableNested3.addCell(new Cell().add(reqDto.getQuantity() + " "+ reqDto.getTicketClass() +" @Afl. " + Double.toString(reqDto.getTicketAmount())).setBorder(Border.NO_BORDER)); 
			
			float columWidthNested4[]= {20,230};
//			Table tableNested4 = new Table(columWidthNested4);
//			tableNested4.addCell(new Cell().add(tickk).setBorder(Border.NO_BORDER));
//			tableNested4.addCell(new Cell().add(reqDto.getQuantity() + " SEH - VIP Single @Afl. 100.00" +Double.toString(reqDto.getTicketAmount())).setBorder(Border.NO_BORDER));
			
			float columWidth[]= {250,250};
			Table table = new Table(columWidth);
			
			bookingDate = StringUtils.isEmpty(reqDto.getBookingDate())? "Booking Date :"+ " May 11, 2023 " : "Booking Date :"+reqDto.getBookingDate(); // ticket.getTitanEventFixtures().getFixtures()
			orderID = StringUtils.isEmpty(reqDto.getOrderId())? "Order ID : \n"+ " 27484 " : "Order ID : \n"+reqDto.getOrderId();// ticket.getTitanOrder().getId();
			ticketID = StringUtils.isEmpty(reqDto.getTicketId())?ticketID = "Ticket ID : \n"+ " 284 " : "Ticket ID : \n"+ reqDto.getTicketId();//ticket.getId();
			ticketClass = StringUtils.isEmpty(reqDto.getTicketClass())?"Ticket Class : \n"+ " SEH - Ultra Early Bird " :  "Ticket Class : \n"+ reqDto.getTicketClass();//ticket.getTitanEventVenueTicketSubClass().getTitanEventVenueTicketClass().getTicketClass();
			eventDet = StringUtils.isEmpty(reqDto.getEventName())? "Event Details : \n"+ " Aruba's 65th Annual Celebrations 2022 " : "Event Details : \n"+ reqDto.getEventName();//ticket.getTitanEventFixtures().getTitanEventVenues().getTitanEvents().getName();

			String pay = "Payment Summary";
			String tick = "Ticket Subtotal";
//			String eventVenue = "Ticket Class : \n"+ " SEH - Ultra Early Bird ";
			String tickCost = "Afl. "+Double.toString(reqDto.getTotal());
			String tickCost1 = Double.toString(reqDto.getTotal());
			String total = "Total Amount";
			String totalAmt = "Afl. "+ Double.toString(reqDto.getFinalTotal());//Double.toString(ticket.getPrice());
			String info = "Information";
			String soc = "Social";
			
//			String png2 = reqDto.getQrImage();        //"C:/Users/Diksha/Downloads/downloadQr.png"
//			ImageData qrImgg = ImageDataFactory.create(png2);
//			Image qrImg = new Image(qrImgg);
//			qrImg.scaleAbsolute(170f, 170f);
//			qrImg.setHorizontalAlignment(HorizontalAlignment.RIGHT);
			
			String png3 =reqDto.getEventImage();// ticket.getTitanEventFixtures().getTitanEventVenues().getTitanEvents().getImagePath();//reqDto.getEventImage();   //"C:/Users/Diksha/Downloads/imagesevent.jpg"
			ImageData eveImgg = ImageDataFactory.create(png3);
			Image eveImg = new Image(eveImgg);
			eveImg.setHorizontalAlignment(HorizontalAlignment.RIGHT);
			eveImg.scaleAbsolute(130f, 60f);
			//Footer
			
			float columWidthNestedFooter[]= {30,50};
			float columWidthNestedFooter1[]= {30,30,30};
			Table tableNestedFooter = new Table(columWidthNestedFooter).setBorder(Border.NO_BORDER);
			Table tableNestedFooter1 = new Table(columWidthNestedFooter);
			Table tableNestedFooter2 = new Table(columWidthNestedFooter);
			Table tableNestedFooter3 = new Table(columWidthNestedFooter);
			Table tableNestedFooter4 = new Table(columWidthNestedFooter1);
			String call = "classpath:/images/tel_icon.png";  //"C:/Users/Diksha/Downloads/phone-call.png"; //call
			ImageData calll = ImageDataFactory.create(call);
			Image cal = new Image(calll);
			cal.setHorizontalAlignment(HorizontalAlignment.RIGHT);
			String whatsapp = "classpath:/images/whatsapp.png";// "C:/Users/Diksha/Downloads/whatsapp.png"; //whatsapp
			ImageData whatsap = ImageDataFactory.create(whatsapp);
			Image whatsa = new Image(whatsap);
			whatsa.setHorizontalAlignment(HorizontalAlignment.RIGHT);
			String email = "classpath:/images/mail_icon.png";// "C:/Users/Diksha/Downloads/emaill.png";
			ImageData emaill = ImageDataFactory.create(email);
			Image emailll = new Image(emaill);
			emailll.setHorizontalAlignment(HorizontalAlignment.RIGHT);
			String world = "classpath:/images/world.png";// "C:/Users/Diksha/Downloads/pdf_Im/whatsapp.png";//
			ImageData worl = ImageDataFactory.create(world);
			Image worldd = new Image(worl);
			worldd.setHorizontalAlignment(HorizontalAlignment.RIGHT);
			
			tableNestedFooter.addCell(new Cell().add(cal).setBorder(Border.NO_BORDER));
			tableNestedFooter.addCell(new Cell().add("149").setBorder(Border.NO_BORDER));
			tableNestedFooter1.addCell(new Cell().add(whatsa).setBorder(Border.NO_BORDER));
			tableNestedFooter1.addCell(new Cell().add("69999999").setBorder(Border.NO_BORDER));
			tableNestedFooter2.addCell(new Cell().add(emailll).setBorder(Border.NO_BORDER).setPaddingTop(6));
			tableNestedFooter2.addCell(new Cell().add("customercare@pay.aw").setBorder(Border.NO_BORDER));
			tableNestedFooter3.addCell(new Cell().add(worldd).setBorder(Border.NO_BORDER));
			tableNestedFooter3.addCell(new Cell().add("pay.aw").setBorder(Border.NO_BORDER));
			
			//Social Media
			
			String face =  "classpath:/images/facebook.png";//"C:/Users/Diksha/Downloads/facebook.png";
			ImageData fac = ImageDataFactory.create(face);
			Image facc = new Image(fac);
			String youtube = "classpath:/images/youtub.png"; //"C:/Users/Diksha/Downloads/youtub.png";
			ImageData youtub = ImageDataFactory.create(youtube);
			Image youtubb = new Image(youtub);
			String instagram =  "classpath:/images/instagramm.png";//"C:/Users/Diksha/Downloads/instagramm.png";
			ImageData instag = ImageDataFactory.create(instagram);
			Image insta = new Image(instag);
			
			tableNestedFooter4.addCell(new Cell().setBorder(Border.NO_BORDER).add(facc));
			tableNestedFooter4.addCell(new Cell().setBorder(Border.NO_BORDER).add(youtubb));
			tableNestedFooter4.addCell(new Cell().setBorder(Border.NO_BORDER).add(insta));
//			tableNestedFooter4.setHorizontalAlignment(HorizontalAlignment.CENTER);
			tableNestedFooter4.setBorder(Border.NO_BORDER);
			 
			table.addCell(new Cell(0,2).add(pdfImg).setPadding(10).setMarginTop(10));
			table.addCell(new Cell(0,2).setFont(bold).add(bookingDate).setPadding(5).setMarginLeft(5));
			table.addCell(new Cell().setFont(bold).add(orderID).setBorderBottom(Border.NO_BORDER).setBorderRight(Border.NO_BORDER).setPadding(10));
			table.addCell(new Cell(3,0).add(qrImg).setBorderLeft(Border.NO_BORDER).setPadding(10).setMarginTop(-10));
			table.addCell(new Cell().setFont(bold).add(ticketID).setBorderTop(Border.NO_BORDER).setBorderBottom(Border.NO_BORDER).setBorderRight(Border.NO_BORDER).setPadding(10));
			table.addCell(new Cell().setFont(bold).add(ticketClass).setBorderTop(Border.NO_BORDER).setBorderRight(Border.NO_BORDER).setPadding(10).setMarginBottom(10));
			table.addCell(new Cell().setFont(bold).add(eventDet).setBorderBottom(Border.NO_BORDER).setBorderRight(Border.NO_BORDER).setPadding(10));
			table.addCell(new Cell(4,0).add(eveImg).setBorderLeft(Border.NO_BORDER).setPaddingTop(40).setMarginTop(20).setPaddingRight(10));
			table.addCell(new Cell().setFont(bold).add(tableNested).setBorderTop(Border.NO_BORDER).setBorderRight(Border.NO_BORDER).setBorderBottom(Border.NO_BORDER).setPadding(5));
			table.addCell(new Cell().setFont(bold).setBorderTop(Border.NO_BORDER).setBorderBottom(Border.NO_BORDER).setBorderRight(Border.NO_BORDER).add(tableNested1).setPadding(5));
			table.addCell(new Cell().setFont(bold).setBorderTop(Border.NO_BORDER).setBorderRight(Border.NO_BORDER).add(tableNested2).setPadding(5).setMarginBottom(10));
			table.addCell(new Cell(0,2).setFont(bold).setBorderBottom(Border.NO_BORDER).add(pay).setPaddingLeft(10).setPaddingTop(10));
			
			 
//			Payment Ticket Details
			
			table.addCell(new Cell(0,2).setFont(bold).setBorderTop(Border.NO_BORDER).setBorderBottom(Border.NO_BORDER).add(tick).setPaddingLeft(10));
			table.addCell(new Cell().setFont(bold).add(tableNested3).setBorderTop(Border.NO_BORDER).setBorderBottom(Border.NO_BORDER).setBorderRight(Border.NO_BORDER).setPaddingLeft(10).setPaddingTop(10));
			table.addCell(new Cell().setFont(bold).add(tickCost).setTextAlignment(TextAlignment.RIGHT).setBorderTop(Border.NO_BORDER).setBorderBottom(Border.NO_BORDER).setBorderLeft(Border.NO_BORDER).setPaddingRight(10).setPaddingTop(13));
//			table.addCell(new Cell().setFont(bold).add(tableNested4).setBorderTop(Border.NO_BORDER).setBorderBottom(Border.NO_BORDER).setBorderRight(Border.NO_BORDER).setPaddingLeft(10));
//			table.addCell(new Cell().setFont(bold).add(tickCost1).setTextAlignment(TextAlignment.RIGHT).setBorderTop(Border.NO_BORDER).setBorderLeft(Border.NO_BORDER).setPaddingRight(10).setPaddingBottom(20));
			table.addCell(new Cell().add(total).setFont(bold).setBorderRight(Border.NO_BORDER).setPadding(10));
			table.addCell(new Cell().add(totalAmt).setFont(bold).setBorderLeft(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT).setPadding(10));
			
//				Footer Info
			table.addCell(new Cell().setFont(bold).add(info).setBorder(Border.NO_BORDER).setBackgroundColor(Color.DARK_GRAY).setFontColor(Color.WHITE).setPadding(10));
			table.addCell(new Cell().setFont(bold).add(soc).setBorder(Border.NO_BORDER).setBackgroundColor(Color.DARK_GRAY).setFontColor(Color.WHITE).setPadding(10).setPaddingLeft(50)); 
			table.addCell(new Cell().add(tableNestedFooter).setBorder(Border.NO_BORDER).setBorder(Border.NO_BORDER).setBackgroundColor(Color.DARK_GRAY).setFontColor(Color.WHITE));
			table.addCell(new Cell().add("").setBorder(Border.NO_BORDER).setBackgroundColor(Color.DARK_GRAY).setFontColor(Color.WHITE));
			
			table.addCell(new Cell().add(tableNestedFooter1).setBorder(Border.NO_BORDER).setBackgroundColor(Color.DARK_GRAY).setFontColor(Color.WHITE));
			table.addCell(new Cell(3,0).add(tableNestedFooter4).setBorder(Border.NO_BORDER).setBackgroundColor(Color.DARK_GRAY).setFontColor(Color.WHITE).setPaddingLeft(50));
			table.addCell(new Cell().add(tableNestedFooter2).setBorder(Border.NO_BORDER).setBackgroundColor(Color.DARK_GRAY).setFontColor(Color.WHITE));
			table.addCell(new Cell().add(tableNestedFooter3).setBorder(Border.NO_BORDER).setBackgroundColor(Color.DARK_GRAY).setFontColor(Color.WHITE));
			
			document.add(table);
			
			
			document.close();
		 }
		 catch (Exception e)
		 {
			e.printStackTrace();
		 }
		return new ByteArrayInputStream(out.toByteArray());
	}

}

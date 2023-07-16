package com.diksha.pdf;


import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

@Service
public class PdfService {
	
	private Logger log = LoggerFactory.getLogger(PdfService.class);
	
	public ByteArrayInputStream generatePdf(PdfReqDto req) {
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		log.info("generating Pdf..");
		
		try {
		//URL u = new URL("https://stg-cdn.pay.aw/images/email_template/event_timing.png");
		/*URL u = new URL(req.getEventImgUrl());
		int contentLength = u.openConnection().getContentLength();
		InputStream openStream = u.openStream();
		byte[] binaryData = new byte[contentLength];
		
		ImageData qrImgDate = ImageDataFactory.create(binaryData);
		Image qrImg = new Image(qrImgDate);
		qrImg.setHeight(1);
		qrImg.setWidth(1);*/
		//qrImg.setMarginLeft(235).setMarginTop(10);
		//doc.add(qrImg);
		
		PdfDocument pdfDoc = new PdfDocument(new PdfWriter(out));
		Document doc = new Document(pdfDoc);
		
		     String ResourcePath="C:/DEVELOPMENT/pdf-generator-itext/src/main/resources/images";
		
			String imagePath1 =   ResourcePath+"/LOGO.png";
			ImageData imageData1 = ImageDataFactory.create(imagePath1);
			Image pdfImg1=new Image(imageData1);
			pdfImg1.setHeight(80).setWidth(200).setMarginLeft(170).setMarginTop(20);
		
			String imagePath2 =   ResourcePath+"/QRcode.png";
			ImageData imageData2 = ImageDataFactory.create(imagePath2);
			Image pdfImg2=new Image(imageData2);
			pdfImg2.setHeight(100).setWidth(100).setMarginLeft(270);
			
			String imagePath3 =   ResourcePath+"/Event.jpg";
			ImageData imageData3 = ImageDataFactory.create(imagePath3);
			Image pdfImg3=new Image(imageData3);
			pdfImg3.setHeight(100).setWidth(100).setMarginLeft(270).setMarginTop(15).setMarginBottom(15);
			
			String calendeimgpath =   ResourcePath+"/calendar.png";
			ImageData Calendeimgdata = ImageDataFactory.create(calendeimgpath);
			Image calendeimg=new Image(Calendeimgdata);
			calendeimg.setHeight(10).setWidth(10);
		
			String imagePath4 =   ResourcePath+"/clock.jpg";
			ImageData imageData4 = ImageDataFactory.create(imagePath4);
			Image clockimg=new Image(imageData4);
			clockimg.setHeight(10).setWidth(10);
			
			String imagePath5 =   ResourcePath+"/location.png";
			ImageData imageData5 = ImageDataFactory.create(imagePath5);
			Image locationimg=new Image(imageData5);
			locationimg.setHeight(10).setWidth(10);
			
			String imagePath6 =   ResourcePath+"/Tickets.jpg";
			ImageData imageData6 = ImageDataFactory.create(imagePath6);
			Image ticketimg=new Image(imageData6);
			ticketimg.setHeight(10).setWidth(10);
			
			float[] columnWidth = {800f};
			Table table1 = new Table(columnWidth);
			
			Table table2 = new Table(new float[] {400f,400f});
			Table table3 = new Table(new float[] {5f});
			Table table4 = new Table(new float[] {10f});
		
			table3.addCell(new Cell().add("ORDER ID").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT).setFontSize(12));
			table3.addCell(new Cell().add((String.valueOf(req.getOrderId()))).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT).setFontSize(10));
			table3.addCell(new Cell().add("      ").setBorder(Border.NO_BORDER));
			table3.addCell(new Cell().add("TICKET ID").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT).setFontSize(12));
			table3.addCell(new Cell().add(String.valueOf(req.getTicketId())).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT).setFontSize(10));
			table3.addCell(new Cell().add("      ").setBorder(Border.NO_BORDER));table3.addCell(new Cell().add("      ").setBorder(Border.NO_BORDER));
			table3.addCell(new Cell().add("TICKET CLASS").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT).setFontSize(12));
			table3.addCell(new Cell().add(req.getTicketClass()).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT).setFontSize(10));
		
			table2.addCell(new Cell().add(table3).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT).setBorder(Border.NO_BORDER));
			table2.addCell(new Cell().add(pdfImg2).setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(HorizontalAlignment.RIGHT).setBorder(Border.NO_BORDER));
			
			Table table6 = new Table(new float[] {400f,400f});
			
			table4.addCell(new Cell().add("EVENT DETAILS").setTextAlignment(TextAlignment.LEFT).setFontSize(12).setBorder(Border.NO_BORDER));
			table4.addCell(new Cell().add(req.getEventName()).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT).setFontSize(10));
		    
			table6.addCell(new Cell().add(table4).setVerticalAlignment(VerticalAlignment.TOP).setTextAlignment(TextAlignment.LEFT).setBorder(Border.NO_BORDER));
			table6.addCell(new Cell().add(pdfImg3).setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(HorizontalAlignment.RIGHT).setBorder(Border.NO_BORDER));
			
			
			Table table5 = new Table(new float[] {5f,5f});
			
			table5.addCell(new Cell().add(calendeimg).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(HorizontalAlignment.LEFT));
			table5.addCell(new Cell().add(req.getEventDate()).setTextAlignment(TextAlignment.LEFT).setFontSize(10).setBorder(Border.NO_BORDER));
			table5.addCell(new Cell().add(clockimg).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(HorizontalAlignment.LEFT));
			table5.addCell(new Cell().add(req.getEventTime()).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT).setFontSize(10));
			table5.addCell(new Cell().add(locationimg).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(HorizontalAlignment.LEFT));
			table5.addCell(new Cell().add(req.getEventLocation()).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT).setFontSize(10));
			
			table4.addCell(new Cell().add(table5).setBorder(Border.NO_BORDER));
			
			Table table7 = new Table(new float[] {800f});
			
			float[] columnWidth8 = {800f};
			Table table8 = new Table(columnWidth8);
			table8.addCell(new Cell().add(" Payment Summary ").setTextAlignment(TextAlignment.LEFT).setFontSize(10).setBorder(Border.NO_BORDER));
			table8.addCell(new Cell().add("  Ticket Subtotal ").setTextAlignment(TextAlignment.LEFT).setFontSize(10).setBorder(Border.NO_BORDER));
			
			
			Table table9 = new Table(new float[] {400f,400f});
			Table table10 = new Table(new float[] {500f});
			Double TotalAmount=000.00;
			for(AmountDto Amount:req.getAmountList()) {
			table10.addCell(new Cell().add(Amount.getAmount()).setTextAlignment(TextAlignment.RIGHT).setFontSize(10).setBorder(Border.NO_BORDER));
			Double amount  =Double.parseDouble(Amount.getAmount().substring(4, Amount.getAmount().length()));
			TotalAmount += amount;
			}
			
			Table table11 = new Table(new float[] {5f,5f});
			for(TicketSubclassDto ticketSubclass:req.getTicketSubclasses()) {
			table11.addCell(new Cell().add(ticketimg).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(HorizontalAlignment.LEFT));
			table11.addCell(new Cell().add((ticketSubclass.getTicketSubClass())).setTextAlignment(TextAlignment.LEFT).setFontSize(10).setBorder(Border.NO_BORDER));
			}
			
			table9.addCell(new Cell().add(table11).setBorder(Border.NO_BORDER));
			table9.addCell(new Cell().add(table10).setBorder(Border.NO_BORDER));
			table7.addCell(new Cell().add(table8).setBorder(Border.NO_BORDER));
			table7.addCell(new Cell().add(table9).setBorder(Border.NO_BORDER));
			Table table12 = new Table(new float[] {250f,265f});
			
			table12.addCell(new Cell().add(" Total Amount ").setHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setTextAlignment(TextAlignment.LEFT).setFontSize(10).setBorder(Border.NO_BORDER));
			table12.addCell(new Cell().add(" Afl "+String.valueOf(TotalAmount)).setHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setTextAlignment(TextAlignment.RIGHT).setFontSize(10).setBorder(Border.NO_BORDER));
			
			//graybox
			Table table13 = new Table(new float[] {800f});
			table13.setHeight(200f).setBackgroundColor(Color.LIGHT_GRAY).setBorder(Border.NO_BORDER);
	
			Table table14 = new Table(new float[] {400f,400f}).setBorder(Border.NO_BORDER);
			
			table14.addCell(new Cell().add(" Information ").setFontColor(Color.WHITE).setMarginTop(10).setHeight(50f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(14).setBorder(Border.NO_BORDER));
			table14.addCell(new Cell().add(" Social ").setFontColor(Color.WHITE).setMarginTop(10).setHeight(50f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(14).setBorder(Border.NO_BORDER));
			table13.addCell(new Cell().add(table14).setBorder(Border.NO_BORDER));
			Table table15 = new Table(new float[] {2f,700f}).setBorder(Border.NO_BORDER);
			
			String phoneimagePath1 =   ResourcePath+"/phone.jpg";
			ImageData phoneimageData1 = ImageDataFactory.create(phoneimagePath1);
			Image phoneimg1=new Image(phoneimageData1);
			phoneimg1.setHeight(10).setWidth(10);
			table15.addCell(new Cell().add(phoneimg1).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(HorizontalAlignment.LEFT));
			table15.addCell(new Cell().add("149").setFontColor(Color.WHITE).setBorder(Border.NO_BORDER));
			
			String whatsappimagePath2 =   ResourcePath+"/whatsapp.jpg";
			ImageData whatsappimageData2 = ImageDataFactory.create(whatsappimagePath2);
			Image whatsappimg2=new Image(whatsappimageData2);
			whatsappimg2.setHeight(10).setWidth(10);
			table15.addCell(new Cell().add(whatsappimg2).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(HorizontalAlignment.LEFT));
			table15.addCell(new Cell().add("6999999").setFontColor(Color.WHITE).setBorder(Border.NO_BORDER));
			
			String gmailimagePath3 =   ResourcePath+"/gmail.jpg";
			ImageData gmailimageData3 = ImageDataFactory.create(gmailimagePath3);
			Image gmailimg3=new Image(gmailimageData3);
			gmailimg3.setHeight(10).setWidth(10);
			table15.addCell(new Cell().add(gmailimg3).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(HorizontalAlignment.LEFT));
			table15.addCell(new Cell().add("customercare@pay.aw").setFontColor(Color.WHITE).setBorder(Border.NO_BORDER));
			
			String internetimagePath4 =   ResourcePath+"/internet.jpg";
			ImageData internetimageData4 = ImageDataFactory.create(internetimagePath4);
			Image internetimg4=new Image(internetimageData4);
			internetimg4.setHeight(10).setWidth(10);
			table15.addCell(new Cell().add(internetimg4).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(HorizontalAlignment.LEFT));
			table15.addCell(new Cell().add("pay.aw").setFontColor(Color.WHITE).setBorder(Border.NO_BORDER));
			
			table14.addCell(new Cell().add(table15).setBorder(Border.NO_BORDER));
			
			Table table16 = new Table(new float[] {50f,50f,50f}).setBorder(Border.NO_BORDER);//FYI
			
			String facebbokimagePath =   ResourcePath+"/facebook.png";
			ImageData facebbokimageData = ImageDataFactory.create(facebbokimagePath);
			Image facebbokimg=new Image(facebbokimageData);
			facebbokimg.setHeight(30).setWidth(30);
			table16.addCell(new Cell().add(facebbokimg).setBorder(Border.NO_BORDER).setHorizontalAlignment(HorizontalAlignment.RIGHT));
			
		     String youtubeimagePath =   ResourcePath+"/youtube.png";
			ImageData youtubeimageData = ImageDataFactory.create(youtubeimagePath);
			Image youtubeimg=new Image(youtubeimageData);
            youtubeimg.setHeight(30).setWidth(30);   
			table16.addCell(new Cell().add( youtubeimg).setBorder(Border.NO_BORDER).setHorizontalAlignment(HorizontalAlignment.CENTER));
			
			String instagramimagePath =   ResourcePath+"/1instagram.jpg";
			ImageData instagramimageData = ImageDataFactory.create(instagramimagePath);
			Image instagramimg=new Image(instagramimageData);
			instagramimg.setHeight(30).setWidth(30);
			table16.addCell(new Cell().add(instagramimg).setBorder(Border.NO_BORDER).setHorizontalAlignment(HorizontalAlignment.LEFT));
			
			table14.addCell(new Cell().add(table16).setBorder(Border.NO_BORDER));
			
			table1.addCell(new Cell().add(pdfImg1));
			table1.addCell(new Cell().add("BOOKING DATE : "+req.getBookingDate()).setTextAlignment(TextAlignment.LEFT));
			table1.addCell(new Cell().add(table2));
			table1.addCell(new Cell().add(table6));
			table1.addCell(new Cell().add(table7));
			table1.addCell(new Cell().add(table12));
			table1.addCell(new Cell().add(table13).setBorder(Border.NO_BORDER));
			doc.add(table1);
			doc.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ByteArrayInputStream(out.toByteArray());
		}}

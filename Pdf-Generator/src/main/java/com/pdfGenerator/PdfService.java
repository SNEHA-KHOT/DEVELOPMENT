package com.pdfGenerator;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.lowagie.text.Chunk;
import com.lowagie.text.DocListener;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Header;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.List;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;

import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfService {
	
	private Logger log = LoggerFactory.getLogger(PdfService.class);
	
	public ByteArrayInputStream generatePdf() {
		
		log.info("generating Pdf..");
		
		String title = "WELCOME" ;
		String content ="Let's generate Pdf ";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Document doc = new Document();
		
		PdfWriter.getInstance(doc, out);
	
		HeaderFooter footer = new HeaderFooter(true,new Phrase("FOOTER"));
		footer.setAlignment(Element.ALIGN_CENTER);
		footer.setBorderWidthBottom(0);
		//Color backgroundColor=Color.orange;
		footer.setBackgroundColor( Color.YELLOW);
		//doc.setDocumentLanguage("en");
		doc.setFooter(footer);
		HeaderFooter header = new HeaderFooter(true,new Phrase("HEADER"));
		header.setAlignment(Element.ALIGN_CENTER);
		header.setBorderWidthBottom(0);
		//Color backgroundColor=Color.orange;
		header.setBackgroundColor( Color.CYAN);
	doc.setHeader(header);
		
		doc.open();
		
		Table table=new Table(100);
		//PdfTable table1 = new PdfTable(table);
		
		Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
		Paragraph titlePara = new Paragraph(title,titleFont);
		titlePara.setAlignment(Element.ALIGN_CENTER);
		
		doc.add(titlePara);
		//new float[] {67,33}
		
		Font paraFont = FontFactory.getFont(FontFactory.HELVETICA, 10);
		Paragraph Para = new Paragraph(content);
	    Para.setSpacingBefore(10f);
	    Para.setSpacingBefore(10f);
		Para.add(new Chunk("text added after creating paragraph"));
		Para.setAlignment(Element.ALIGN_LEFT);
		
		List list = new List();
		list.add("Java");
		list.add("Python");
		list.add("C++");
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("ticket1" ,1);
		doc.addTitle(title);
		//doc.addDocListener();
		//doc.add((Element) map);
		
		
	
		doc.add(Para);
		doc.add(list);
		doc.close();
		
		return new ByteArrayInputStream(out.toByteArray());
	}
	
	
	
	

}

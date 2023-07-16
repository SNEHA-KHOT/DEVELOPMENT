package com.diksha.pdf;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdfController {

	@Autowired
	PdfService pdfService;
	
	
	@PostMapping("/generatePdf")
	public ResponseEntity<InputStreamResource> generatePdf(@RequestBody PdfReqDto req) {
		
	   ByteArrayInputStream pdf =pdfService.generatePdf(req);
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.add("Content-Disposition ", "inline;DikshaTitan.pdf");
		return ResponseEntity
				.ok()
				.headers(httpHeaders)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(pdf));
		
}}

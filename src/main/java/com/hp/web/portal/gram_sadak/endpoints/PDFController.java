package com.hp.web.portal.gram_sadak.endpoints;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hp.web.portal.gram_sadak.model.TestResultSheet;
import com.hp.web.portal.gram_sadak.service.IPdfService;

@Controller
public class PDFController {
	
	@Autowired
	private IPdfService pdfService;
	
	
	@RequestMapping(path = "/testResultSheet/pdf")
    public ResponseEntity<?> generateTestResultSheetPDF(@ModelAttribute TestResultSheet testResultSheet,HttpServletRequest request, HttpServletResponse response) throws IOException {
		return pdfService.generateTestResultSheetPDF(testResultSheet, request, response);
    }
}

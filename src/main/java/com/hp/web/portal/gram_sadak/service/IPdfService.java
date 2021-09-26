package com.hp.web.portal.gram_sadak.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.hp.web.portal.gram_sadak.model.TestResultSheet;

public interface IPdfService {
	
	/**
	 * Method to generate test result sheet form PDF.
	 * @param testResultSheet
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	ResponseEntity<?> generateTestResultSheetPDF(@ModelAttribute TestResultSheet testResultSheet,HttpServletRequest request, HttpServletResponse response) throws IOException;
	

}

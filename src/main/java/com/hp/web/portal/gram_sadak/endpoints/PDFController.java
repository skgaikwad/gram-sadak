package com.hp.web.portal.gram_sadak.endpoints;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.web.portal.gram_sadak.model.Bricks;
import com.hp.web.portal.gram_sadak.model.ConcreteCubes;
import com.hp.web.portal.gram_sadak.model.PaverBlock;
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
	
	
	@RequestMapping(path = "/concreteCubesResultSheet/pdf")
    public ResponseEntity<?> generateConcreteCubesResultSheetPDF(@ModelAttribute ConcreteCubes concreteCubes, HttpServletRequest request, HttpServletResponse response) throws IOException {
		return pdfService.generateConcreteCubesResultSheetPDF(concreteCubes, request, response);
    }

	@RequestMapping(path = "/bricksTestResultSheet/pdf")
	public ResponseEntity<?> generateBricksTestResultSheetPDF(@ModelAttribute Bricks bricks, HttpServletRequest request, HttpServletResponse response) throws IOException {
		return pdfService.generateBricksTestResultSheetPDF(bricks, request, response);
	}

	@RequestMapping(path = "/paverBlockTestResultSheet/pdf")
	public ResponseEntity<?> generatePaverBlockTestResultSheetPDF(@ModelAttribute PaverBlock paverBlock, HttpServletRequest request, HttpServletResponse response) throws IOException {
		return pdfService.generatePaverBlockTestResultSheetPDF(paverBlock, request, response);
	}
}

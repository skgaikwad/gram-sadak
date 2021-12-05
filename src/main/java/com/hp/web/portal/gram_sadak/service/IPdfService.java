package com.hp.web.portal.gram_sadak.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.web.portal.gram_sadak.model.Bricks;
import com.hp.web.portal.gram_sadak.model.ConcreteCubes;
import com.hp.web.portal.gram_sadak.model.PaverBlock;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.hp.web.portal.gram_sadak.model.TestResultSheet;

public interface IPdfService {
	

	ResponseEntity<?> generateConcreteCubesResultSheetPDF(@ModelAttribute TestResultSheet testResultSheet, HttpServletRequest request, HttpServletResponse response) throws IOException;


	ResponseEntity<?> generateBricksTestResultSheetPDF(@ModelAttribute TestResultSheet testResultSheet, HttpServletRequest request, HttpServletResponse response) throws IOException;


	ResponseEntity<?> generatePaverBlockTestResultSheetPDF(@ModelAttribute TestResultSheet testResultSheet, HttpServletRequest request, HttpServletResponse response) throws IOException;


}

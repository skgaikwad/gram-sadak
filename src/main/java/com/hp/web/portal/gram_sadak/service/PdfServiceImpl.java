package com.hp.web.portal.gram_sadak.service;

import com.hp.web.portal.gram_sadak.model.TestResultSheet;
import com.hp.web.portal.gram_sadak.repository.JobRepository;
import com.hp.web.portal.gram_sadak.repository.TransactionRepository;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfServiceImpl implements IPdfService {

    Logger LOG = LogManager.getLogger(PdfServiceImpl.class);
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private ServletContext servletContext;

	public ResponseEntity<?> generateConcreteCubesResultSheetPDF(@ModelAttribute TestResultSheet testResultSheet, HttpServletRequest request, HttpServletResponse response) throws IOException {

		/*
		 * Overridden updated job id and transaction id for unique id*/

		Integer jobId = jobRepository.getNewJobId();
		Integer transactionId = transactionRepository.getNewTransactionId();

		testResultSheet.setTransactionId(transactionId);
		testResultSheet.setJobId(jobId);

		/* Create HTML using Thymeleaf template Engine */
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("concreteCubes", testResultSheet);

		String testResultSheetHtml = templateEngine.process("concreteCubesResultSheetPdf", context);

		/* Setup Source and target I/O streams */

		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");


		/* Call convert method */
		HtmlConverter.convertToPdf(testResultSheetHtml, target, converterProperties);


       /* PdfDocument pdfDocument = new PdfDocument(new PdfWriter(new File(sourcePath)));
        pdfDocument.setDefaultPageSize(PageSize.A4.rotate());
        HtmlConverter.convertToPdf(new FileInputStream(destPath), pdfDocument, props);*/

		/* extract output as bytes */
		byte[] bytes = target.toByteArray();

		/* Increment counters*/
		incrementDownloadIndex(testResultSheet);

		/* Send the response as downloadable PDF */
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=testResultSheetPdf.pdf")
				.contentType(MediaType.APPLICATION_PDF)
				.body(bytes);

	}

	public ResponseEntity<?> generateBricksTestResultSheetPDF(@ModelAttribute TestResultSheet testResultSheet, HttpServletRequest request, HttpServletResponse response) throws IOException {

		/*
		 * Overridden updated job id and transaction id for unique id*/

		Integer jobId = jobRepository.getNewJobId();
		Integer transactionId = transactionRepository.getNewTransactionId();

		testResultSheet.setTransactionId(transactionId);
		testResultSheet.setJobId(jobId);

		/* Create HTML using Thymeleaf template Engine */
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("bricks", testResultSheet);

		String testResultSheetHtml = templateEngine.process("bricksTestResultSheetPdf", context);

		/* Setup Source and target I/O streams */

		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");


		/* Call convert method */
		HtmlConverter.convertToPdf(testResultSheetHtml, target, converterProperties);


       /* PdfDocument pdfDocument = new PdfDocument(new PdfWriter(new File(sourcePath)));
        pdfDocument.setDefaultPageSize(PageSize.A4.rotate());
        HtmlConverter.convertToPdf(new FileInputStream(destPath), pdfDocument, props);*/

		/* extract output as bytes */
		byte[] bytes = target.toByteArray();

		/* Increment counters*/
		incrementDownloadIndex(testResultSheet);

		/* Send the response as downloadable PDF */
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=bricksTestResultSheetPdf.pdf")
				.contentType(MediaType.APPLICATION_PDF)
				.body(bytes);

    }

	public ResponseEntity<?> generatePaverBlockTestResultSheetPDF(@ModelAttribute TestResultSheet testResultSheet, HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*
		 * Overridden updated job id and transaction id for unique id*/

		Integer jobId = jobRepository.getNewJobId();
		Integer transactionId = transactionRepository.getNewTransactionId();

		testResultSheet.setTransactionId(transactionId);
		testResultSheet.setJobId(jobId);

		/* Create HTML using Thymeleaf template Engine */
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("paverBlock", testResultSheet);

		String testResultSheetHtml = templateEngine.process("paverBlockTestResultSheetPdf", context);

		/* Setup Source and target I/O streams */

		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");


		/* Call convert method */
		HtmlConverter.convertToPdf(testResultSheetHtml, target, converterProperties);

		/* extract output as bytes */
		byte[] bytes = target.toByteArray();

		/* Increment counters*/
		incrementDownloadIndex(testResultSheet);

		/* Send the response as downloadable PDF */
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=paverBlockTestResultSheetPdf.pdf")
				.contentType(MediaType.APPLICATION_PDF)
				.body(bytes);
	}

	@Transactional
	private void incrementDownloadIndex(TestResultSheet testResultSheet ) {
		
		LOG.info("#### Increment job and transaction id");
		jobRepository.incrementJobId(testResultSheet.getJobId());
		transactionRepository.incrementTransactionId(testResultSheet.getTransactionId());
		
		/*Job job = new Job();
		job.setJobId(testResultSheet.getJobId());
		jobRepository.save(job);
		
		Transaction transaction = new Transaction();
		transaction.setId(testResultSheet.getTransactionId());
		transactionRepository.save(transaction);*/
	}

}

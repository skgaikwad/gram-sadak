package com.hp.web.portal.gram_sadak.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hp.web.portal.gram_sadak.model.TestResultSheet;
import com.hp.web.portal.gram_sadak.model.TestResultSheetMapping;
import com.hp.web.portal.gram_sadak.repository.JobRepository;
import com.hp.web.portal.gram_sadak.repository.TransactionRepository;

@Service
public class FormService implements IFormService {
	
	Logger LOG = LogManager.getLogger(FormService.class);
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public String index(Model model) {
		return "index";
	}
		
	public String testResultSheet(Model model) {
		Integer jobId = jobRepository.getNewJobId();
		Integer transactionId = transactionRepository.getNewTransactionId();
		
		TestResultSheet testResultSheet = new TestResultSheet();
		testResultSheet.setTransactionId(transactionId);
		testResultSheet.setJobId(jobId);
		
		List<TestResultSheetMapping> testResultSheetMappingList = new ArrayList<TestResultSheetMapping>();
		testResultSheetMappingList.add(new TestResultSheetMapping("1"));
		testResultSheetMappingList.add(new TestResultSheetMapping("2"));
		testResultSheetMappingList.add(new TestResultSheetMapping("3"));

		testResultSheet.setTestResultSheetMappingList(testResultSheetMappingList);
		
		model.addAttribute("testResultSheet", testResultSheet);
		
		return "testResultSheet";
	}
}

package com.hp.web.portal.gram_sadak.service;

import org.springframework.ui.Model;

public interface IFormService {
	
	
	/**
	 * Get list of all forms
	 * @param model
	 * @return
	 */
	String index(Model model); 
	
	/**
	 * Get test result sheet form with default values like job id and transaction id
	 * @param model
	 * @return
	 */
	String testResultSheet(Model model); 

}

package com.hp.web.portal.gram_sadak.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hp.web.portal.gram_sadak.service.IFormService;

@Controller
public class FormController {
	
	@Autowired
	private IFormService formService;
	
	@GetMapping("/")
	public String index(Model model) {
		return formService.index(model);
	}
	
	@GetMapping("/testResultSheet")
	public String testResultSheet(Model model) {
		return formService.testResultSheet(model);
	}

}

package com.hp.web.portal.gram_sadak.service;

import org.springframework.ui.Model;

public interface IFormService {
	
	String index(Model model);

	String testResultConcreteCubes(Model model);

	String testResultBricks(Model model);

	String testResultConcretePaverBlock(Model model);

	String testResultCrushedMetal(Model model);

	String testResultExtraction(Model model);

	String testResultHBMetal(Model model);

	String testResultMetal(Model model);

	String testResultMurum(Model model);

	String testResultPenetretion(Model model);

	String testResultRubble(Model model);

	String testResultSand(Model model);

	String testResultTiles(Model model);

    String testResultGsb(Model model);

	String testResultSoil(Model model);

	String testResultSoilSieveAnalysis(Model model);

	String testResultCement(Model model);
}

package com.hp.web.portal.gram_sadak.model;

import java.util.List;

public class SoilSieveAnalysis extends TestResultSheet {

	private List<SoilSieveAnalysisMapping> soilSieveAnalysisMappingList;

	public List<SoilSieveAnalysisMapping> getSoilSieveAnalysisMappingList() {
		return soilSieveAnalysisMappingList;
	}

	public void setSoilSieveAnalysisMappingList(List<SoilSieveAnalysisMapping> soilSieveAnalysisMappingList) {
		this.soilSieveAnalysisMappingList = soilSieveAnalysisMappingList;
	}
}

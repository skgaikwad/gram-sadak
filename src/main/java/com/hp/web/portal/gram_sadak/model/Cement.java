package com.hp.web.portal.gram_sadak.model;

import java.util.List;

public class Cement extends TestResultSheet {

	private List<CementMapping> cementMappingList;

	public List<CementMapping> getCementMappingList() {
		return cementMappingList;
	}

	public void setCementMappingList(List<CementMapping> cementMappingList) {
		this.cementMappingList = cementMappingList;
	}
}

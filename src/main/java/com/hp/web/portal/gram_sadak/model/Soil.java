package com.hp.web.portal.gram_sadak.model;

import java.util.List;

public class Soil extends TestResultSheet {

	private List<SoilMapping> soilMappingList;

	public List<SoilMapping> getSoilMappingList() {
		return soilMappingList;
	}

	public void setSoilMappingList(List<SoilMapping> soilMappingList) {
		this.soilMappingList = soilMappingList;
	}
}

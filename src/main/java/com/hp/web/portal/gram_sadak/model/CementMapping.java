package com.hp.web.portal.gram_sadak.model;

public class CementMapping {

	private String srNo;
	private String material;
	private String initialSettingTime;
	private String finalSettingTime;

	private String compressiveStrength43Grade7Days;
	private String compressiveStrength43Grade28Days;
	private String compressiveStrength53Grade7Days;
	private String compressiveStrength53Grade28Days;

	public CementMapping() {
	}

	public CementMapping(String srNo) {
		super();
		this.srNo = srNo;
	}

	public String getSrNo() {
		return srNo;
	}

	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getInitialSettingTime() {
		return initialSettingTime;
	}

	public void setInitialSettingTime(String initialSettingTime) {
		this.initialSettingTime = initialSettingTime;
	}

	public String getFinalSettingTime() {
		return finalSettingTime;
	}

	public void setFinalSettingTime(String finalSettingTime) {
		this.finalSettingTime = finalSettingTime;
	}

	public String getCompressiveStrength43Grade7Days() {
		return compressiveStrength43Grade7Days;
	}

	public void setCompressiveStrength43Grade7Days(String compressiveStrength43Grade7Days) {
		this.compressiveStrength43Grade7Days = compressiveStrength43Grade7Days;
	}

	public String getCompressiveStrength43Grade28Days() {
		return compressiveStrength43Grade28Days;
	}

	public void setCompressiveStrength43Grade28Days(String compressiveStrength43Grade28Days) {
		this.compressiveStrength43Grade28Days = compressiveStrength43Grade28Days;
	}

	public String getCompressiveStrength53Grade7Days() {
		return compressiveStrength53Grade7Days;
	}

	public void setCompressiveStrength53Grade7Days(String compressiveStrength53Grade7Days) {
		this.compressiveStrength53Grade7Days = compressiveStrength53Grade7Days;
	}

	public String getCompressiveStrength53Grade28Days() {
		return compressiveStrength53Grade28Days;
	}

	public void setCompressiveStrength53Grade28Days(String compressiveStrength53Grade28Days) {
		this.compressiveStrength53Grade28Days = compressiveStrength53Grade28Days;
	}
}

package com.hp.web.portal.gram_sadak.model;

public class SoilMapping {

    private String srNo;
    private String nameOfTest;
    private String maximumDryDensity;
    private String optimumMoistureContent;
    private String proctorDensityInGmCc;

    public SoilMapping() {
    }

    public SoilMapping(String srNo) {
        super();
        this.srNo = srNo;
    }

    public String getSrNo() {
        return srNo;
    }

    public void setSrNo(String srNo) {
        this.srNo = srNo;
    }

    public String getNameOfTest() {
        return nameOfTest;
    }

    public void setNameOfTest(String nameOfTest) {
        this.nameOfTest = nameOfTest;
    }

    public String getMaximumDryDensity() {
        return maximumDryDensity;
    }

    public void setMaximumDryDensity(String maximumDryDensity) {
        this.maximumDryDensity = maximumDryDensity;
    }

    public String getOptimumMoistureContent() {
        return optimumMoistureContent;
    }

    public void setOptimumMoistureContent(String optimumMoistureContent) {
        this.optimumMoistureContent = optimumMoistureContent;
    }

    public String getProctorDensityInGmCc() {
        return proctorDensityInGmCc;
    }

    public void setProctorDensityInGmCc(String proctorDensityInGmCc) {
        this.proctorDensityInGmCc = proctorDensityInGmCc;
    }
}

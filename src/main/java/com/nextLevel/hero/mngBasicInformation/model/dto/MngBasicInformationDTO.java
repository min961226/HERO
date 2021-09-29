package com.nextLevel.hero.mngBasicInformation.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class MngBasicInformationDTO implements Serializable{

	private int companyNo;
	private String companyName;
	private String ceoName;
	private String address;
	private String addressDetail;
	private String phone;
	private String fax;
	private String companyRegistrationNo;
	private String companyRegistrationNo1;
	private String companyRegistrationNo2;
	private String companyRegistrationNo3;
	private String identificationNo;
	private String identificationNo1;
	private String identificationNo2;
	private String managerEmail;
	private String website;
	private Date foundingDate;
	private char firstCompanyYn;
	private int businessCode;
	private String businessName;
	
	public MngBasicInformationDTO() {}

	public MngBasicInformationDTO(int companyNo, String companyName, String ceoName, String address,
			String addressDetail, String phone, String fax, String companyRegistrationNo, String companyRegistrationNo1,
			String companyRegistrationNo2, String companyRegistrationNo3, String identificationNo,
			String identificationNo1, String identificationNo2, String managerEmail, String website, Date foundingDate,
			char firstCompanyYn, int businessCode, String businessName) {
		super();
		this.companyNo = companyNo;
		this.companyName = companyName;
		this.ceoName = ceoName;
		this.address = address;
		this.addressDetail = addressDetail;
		this.phone = phone;
		this.fax = fax;
		this.companyRegistrationNo = companyRegistrationNo;
		this.companyRegistrationNo1 = companyRegistrationNo1;
		this.companyRegistrationNo2 = companyRegistrationNo2;
		this.companyRegistrationNo3 = companyRegistrationNo3;
		this.identificationNo = identificationNo;
		this.identificationNo1 = identificationNo1;
		this.identificationNo2 = identificationNo2;
		this.managerEmail = managerEmail;
		this.website = website;
		this.foundingDate = foundingDate;
		this.firstCompanyYn = firstCompanyYn;
		this.businessCode = businessCode;
		this.businessName = businessName;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCeoName() {
		return ceoName;
	}

	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCompanyRegistrationNo() {
		return companyRegistrationNo;
	}

	public void setCompanyRegistrationNo(String companyRegistrationNo) {
		this.companyRegistrationNo = companyRegistrationNo;
	}

	public String getCompanyRegistrationNo1() {
		return companyRegistrationNo1;
	}

	public void setCompanyRegistrationNo1(String companyRegistrationNo1) {
		this.companyRegistrationNo1 = companyRegistrationNo1;
	}

	public String getCompanyRegistrationNo2() {
		return companyRegistrationNo2;
	}

	public void setCompanyRegistrationNo2(String companyRegistrationNo2) {
		this.companyRegistrationNo2 = companyRegistrationNo2;
	}

	public String getCompanyRegistrationNo3() {
		return companyRegistrationNo3;
	}

	public void setCompanyRegistrationNo3(String companyRegistrationNo3) {
		this.companyRegistrationNo3 = companyRegistrationNo3;
	}

	public String getIdentificationNo() {
		return identificationNo;
	}

	public void setIdentificationNo(String identificationNo) {
		this.identificationNo = identificationNo;
	}

	public String getIdentificationNo1() {
		return identificationNo1;
	}

	public void setIdentificationNo1(String identificationNo1) {
		this.identificationNo1 = identificationNo1;
	}

	public String getIdentificationNo2() {
		return identificationNo2;
	}

	public void setIdentificationNo2(String identificationNo2) {
		this.identificationNo2 = identificationNo2;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Date getFoundingDate() {
		return foundingDate;
	}

	public void setFoundingDate(Date foundingDate) {
		this.foundingDate = foundingDate;
	}

	public char getFirstCompanyYn() {
		return firstCompanyYn;
	}

	public void setFirstCompanyYn(char firstCompanyYn) {
		this.firstCompanyYn = firstCompanyYn;
	}

	public int getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(int businessCode) {
		this.businessCode = businessCode;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	@Override
	public String toString() {
		return "MngBasicInformationDTO [companyNo=" + companyNo + ", companyName=" + companyName + ", ceoName="
				+ ceoName + ", address=" + address + ", addressDetail=" + addressDetail + ", phone=" + phone + ", fax="
				+ fax + ", companyRegistrationNo=" + companyRegistrationNo + ", companyRegistrationNo1="
				+ companyRegistrationNo1 + ", companyRegistrationNo2=" + companyRegistrationNo2
				+ ", companyRegistrationNo3=" + companyRegistrationNo3 + ", identificationNo=" + identificationNo
				+ ", identificationNo1=" + identificationNo1 + ", identificationNo2=" + identificationNo2
				+ ", managerEmail=" + managerEmail + ", website=" + website + ", foundingDate=" + foundingDate
				+ ", firstCompanyYn=" + firstCompanyYn + ", businessCode=" + businessCode + ", businessName="
				+ businessName + "]";
	}


}

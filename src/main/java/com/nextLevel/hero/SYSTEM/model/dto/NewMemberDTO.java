package com.nextLevel.hero.SYSTEM.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class NewMemberDTO implements Serializable {

	private int companyNo;
	private String memberId;
	private String memberName;
	private String memberPasswordCheck;
	private String companyName;
	private String ceoName;
	private String address;
	private String addressDetail;
	private String companyPhone;
	private String companyRegistrationNo;
	private String companyRegistrationNo1;
	private String companyRegistrationNo2;
	private String companyRegistrationNo3;
	private String managerName;
	private String managerDept;
	private String managerRank;
	private String managerPhone;
	private String managerEmail;
	private Date startDate;

	
	public NewMemberDTO() {}


	public NewMemberDTO(int companyNo, String memberId, String memberName, String memberPasswordCheck,
			String companyName, String ceoName, String address, String addressDetail, String companyPhone,
			String companyRegistrationNo, String companyRegistrationNo1, String companyRegistrationNo2,
			String companyRegistrationNo3, String managerName, String managerDept, String managerRank,
			String managerPhone, String managerEmail, Date startDate) {
		super();
		this.companyNo = companyNo;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPasswordCheck = memberPasswordCheck;
		this.companyName = companyName;
		this.ceoName = ceoName;
		this.address = address;
		this.addressDetail = addressDetail;
		this.companyPhone = companyPhone;
		this.companyRegistrationNo = companyRegistrationNo;
		this.companyRegistrationNo1 = companyRegistrationNo1;
		this.companyRegistrationNo2 = companyRegistrationNo2;
		this.companyRegistrationNo3 = companyRegistrationNo3;
		this.managerName = managerName;
		this.managerDept = managerDept;
		this.managerRank = managerRank;
		this.managerPhone = managerPhone;
		this.managerEmail = managerEmail;
		this.startDate = startDate;
	}


	public int getCompanyNo() {
		return companyNo;
	}


	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getMemberPasswordCheck() {
		return memberPasswordCheck;
	}


	public void setMemberPasswordCheck(String memberPasswordCheck) {
		this.memberPasswordCheck = memberPasswordCheck;
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


	public String getCompanyPhone() {
		return companyPhone;
	}


	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
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


	public String getManagerName() {
		return managerName;
	}


	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}


	public String getManagerDept() {
		return managerDept;
	}


	public void setManagerDept(String managerDept) {
		this.managerDept = managerDept;
	}


	public String getManagerRank() {
		return managerRank;
	}


	public void setManagerRank(String managerRank) {
		this.managerRank = managerRank;
	}


	public String getManagerPhone() {
		return managerPhone;
	}


	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}


	public String getManagerEmail() {
		return managerEmail;
	}


	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	@Override
	public String toString() {
		return "NewMemberDTO [companyNo=" + companyNo + ", memberId=" + memberId + ", memberName=" + memberName
				+ ", memberPasswordCheck=" + memberPasswordCheck + ", companyName=" + companyName + ", ceoName="
				+ ceoName + ", address=" + address + ", addressDetail=" + addressDetail + ", companyPhone="
				+ companyPhone + ", companyRegistrationNo=" + companyRegistrationNo + ", companyRegistrationNo1="
				+ companyRegistrationNo1 + ", companyRegistrationNo2=" + companyRegistrationNo2
				+ ", companyRegistrationNo3=" + companyRegistrationNo3 + ", managerName=" + managerName
				+ ", managerDept=" + managerDept + ", managerRank=" + managerRank + ", managerPhone=" + managerPhone
				+ ", managerEmail=" + managerEmail + ", startDate=" + startDate + "]";
	}


	
	
	
}

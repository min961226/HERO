package com.nextLevel.hero.mngBasicInformation.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class MngDepartmentHistoryDTO implements Serializable{

	private int companyNo;
	private int updatedHistoryNo;
	private int memberNo;
	private int departmentNo;
	private String departmentName;
	private Date departmentCreateDate;
	private String departmentPhone;
	private Date departmentUpdatedDate;
	private String updatedCategory;
	
	public MngDepartmentHistoryDTO() {}

	public MngDepartmentHistoryDTO(int companyNo, int updatedHistoryNo, int memberNo, int departmentNo,
			String departmentName, Date departmentCreateDate, String departmentPhone, Date departmentUpdatedDate,
			String updatedCategory) {
		super();
		this.companyNo = companyNo;
		this.updatedHistoryNo = updatedHistoryNo;
		this.memberNo = memberNo;
		this.departmentNo = departmentNo;
		this.departmentName = departmentName;
		this.departmentCreateDate = departmentCreateDate;
		this.departmentPhone = departmentPhone;
		this.departmentUpdatedDate = departmentUpdatedDate;
		this.updatedCategory = updatedCategory;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public int getUpdatedHistoryNo() {
		return updatedHistoryNo;
	}

	public void setUpdatedHistoryNo(int updatedHistoryNo) {
		this.updatedHistoryNo = updatedHistoryNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(int departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Date getDepartmentCreateDate() {
		return departmentCreateDate;
	}

	public void setDepartmentCreateDate(Date departmentCreateDate) {
		this.departmentCreateDate = departmentCreateDate;
	}

	public String getDepartmentPhone() {
		return departmentPhone;
	}

	public void setDepartmentPhone(String departmentPhone) {
		this.departmentPhone = departmentPhone;
	}

	public Date getDepartmentUpdatedDate() {
		return departmentUpdatedDate;
	}

	public void setDepartmentUpdatedDate(Date departmentUpdatedDate) {
		this.departmentUpdatedDate = departmentUpdatedDate;
	}

	public String getUpdatedCategory() {
		return updatedCategory;
	}

	public void setUpdatedCategory(String updatedCategory) {
		this.updatedCategory = updatedCategory;
	}

	@Override
	public String toString() {
		return "MngDepartmentHistoryDTO [companyNo=" + companyNo + ", updatedHistoryNo=" + updatedHistoryNo
				+ ", memberNo=" + memberNo + ", departmentNo=" + departmentNo + ", departmentName=" + departmentName
				+ ", departmentCreateDate=" + departmentCreateDate + ", departmentPhone=" + departmentPhone
				+ ", departmentUpdatedDate=" + departmentUpdatedDate + ", updatedCategory=" + updatedCategory + "]";
	}
	
	
	
	
	
}

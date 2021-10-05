package com.nextLevel.hero.mngBasicInformation.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class MngDepartmentHistoryDTO implements Serializable{

	private int companyNo;
	private int updatedHistoryNo;
	private int departmentNo;
	private String departmentName;
	private Date departmentCreateDate;
	private String departmentPhone;
	private Date departmentUpdatedDate;
	private String updatedCategory;
	private String departmentDetail;
	private Integer upperDepartment;
	private String upperDepartmentName;
	private Integer memberCount;
	
	public MngDepartmentHistoryDTO() {}

	public MngDepartmentHistoryDTO(int companyNo, int updatedHistoryNo, int departmentNo, String departmentName,
			Date departmentCreateDate, String departmentPhone, Date departmentUpdatedDate, String updatedCategory,
			String departmentDetail, Integer upperDepartment, String upperDepartmentName, Integer memberCount) {
		super();
		this.companyNo = companyNo;
		this.updatedHistoryNo = updatedHistoryNo;
		this.departmentNo = departmentNo;
		this.departmentName = departmentName;
		this.departmentCreateDate = departmentCreateDate;
		this.departmentPhone = departmentPhone;
		this.departmentUpdatedDate = departmentUpdatedDate;
		this.updatedCategory = updatedCategory;
		this.departmentDetail = departmentDetail;
		this.upperDepartment = upperDepartment;
		this.upperDepartmentName = upperDepartmentName;
		this.memberCount = memberCount;
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

	public String getDepartmentDetail() {
		return departmentDetail;
	}

	public void setDepartmentDetail(String departmentDetail) {
		this.departmentDetail = departmentDetail;
	}

	public Integer getUpperDepartment() {
		return upperDepartment;
	}

	public void setUpperDepartment(Integer upperDepartment) {
		this.upperDepartment = upperDepartment;
	}

	public String getUpperDepartmentName() {
		return upperDepartmentName;
	}

	public void setUpperDepartmentName(String upperDepartmentName) {
		this.upperDepartmentName = upperDepartmentName;
	}

	public Integer getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}

	@Override
	public String toString() {
		return "MngDepartmentHistoryDTO [companyNo=" + companyNo + ", updatedHistoryNo=" + updatedHistoryNo
				+ ", departmentNo=" + departmentNo + ", departmentName=" + departmentName + ", departmentCreateDate="
				+ departmentCreateDate + ", departmentPhone=" + departmentPhone + ", departmentUpdatedDate="
				+ departmentUpdatedDate + ", updatedCategory=" + updatedCategory + ", departmentDetail="
				+ departmentDetail + ", upperDepartment=" + upperDepartment + ", upperDepartmentName="
				+ upperDepartmentName + ", memberCount=" + memberCount + "]";
	}


	
	
}

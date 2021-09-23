package com.nextLevel.hero.mngCertificate.model.dto;

import java.util.Date;

public class CertificateMemberDTO {
					
	private int requestNo;									//요청 번호		
	private int memberNo;									//사번			TBL_REQUEST_CERTIFICATION 조인 회사번호로
	private String memberName;								//이름			TBL_REQUEST_CERTIFICATION 조인 회사번호로
	private String departmentName;							//부서명			TBL_DEPARTMENT 조인 회사번호로
	private String rank;									//직급 			TBL_RNAK_SALARY_STEP 조인 회사번호로
	private java.util.Date requestDate;						//신청일자			TBL_REQUEST_CERTIFICATION 조인 회사번호로
	private java.util.Date successedDate;					//처리일자			TBL_REQUEST_CERTIFICATION 조인 회사번호로
	private String issueStatus;								//발급상태
	private String certificationPurpose;					//용도
	private int certificationNo;							//증명서번호
	private int companyNo;									//회사번호
	private int departmentNo;								//부서번호
	
	CertificateMemberDTO(){}

	public CertificateMemberDTO(int requestNo, int memberNo, String memberName, String departmentName, String rank,
			Date requestDate, Date successedDate, String issueStatus, String certificationPurpose, int certificationNo,
			int companyNo, int departmentNo) {
		super();
		this.requestNo = requestNo;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.departmentName = departmentName;
		this.rank = rank;
		this.requestDate = requestDate;
		this.successedDate = successedDate;
		this.issueStatus = issueStatus;
		this.certificationPurpose = certificationPurpose;
		this.certificationNo = certificationNo;
		this.companyNo = companyNo;
		this.departmentNo = departmentNo;
	}

	public int getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(int requestNo) {
		this.requestNo = requestNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public java.util.Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(java.util.Date requestDate) {
		this.requestDate = requestDate;
	}

	public java.util.Date getSuccessedDate() {
		return successedDate;
	}

	public void setSuccessedDate(java.util.Date successedDate) {
		this.successedDate = successedDate;
	}

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public String getCertificationPurpose() {
		return certificationPurpose;
	}

	public void setCertificationPurpose(String certificationPurpose) {
		this.certificationPurpose = certificationPurpose;
	}

	public int getCertificationNo() {
		return certificationNo;
	}

	public void setCertificationNo(int certificationNo) {
		this.certificationNo = certificationNo;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public int getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(int departmentNo) {
		this.departmentNo = departmentNo;
	}

	@Override
	public String toString() {
		return "CertificateMemberDTO [requestNo=" + requestNo + ", memberNo=" + memberNo + ", memberName=" + memberName
				+ ", departmentName=" + departmentName + ", rank=" + rank + ", requestDate=" + requestDate
				+ ", successedDate=" + successedDate + ", issueStatus=" + issueStatus + ", certificationPurpose="
				+ certificationPurpose + ", certificationNo=" + certificationNo + ", companyNo=" + companyNo
				+ ", departmentNo=" + departmentNo + "]";
	}

}

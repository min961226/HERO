package com.nextLevel.hero.mngCertificate.model.dto;

import java.util.Date;

public class CertificateMemberDTO {
					
	private int idNo;
	private int memberNo;
	private String memberName;
	private String jobName;
	private String departmentName;
	private String memberId;
	private java.util.Date hireDate;
	private java.util.Date accSecessionDatetime;
	
	CertificateMemberDTO(){}

	public CertificateMemberDTO(int idNo, int memberNo, String memberName, String jobName, String departmentName,
			String memberId, Date hireDate, Date accSecessionDatetime) {
		super();
		this.idNo = idNo;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.jobName = jobName;
		this.departmentName = departmentName;
		this.memberId = memberId;
		this.hireDate = hireDate;
		this.accSecessionDatetime = accSecessionDatetime;
	}

	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
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

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public java.util.Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(java.util.Date hireDate) {
		this.hireDate = hireDate;
	}

	public java.util.Date getAccSecessionDatetime() {
		return accSecessionDatetime;
	}

	public void setAccSecessionDatetime(java.util.Date accSecessionDatetime) {
		this.accSecessionDatetime = accSecessionDatetime;
	}

	@Override
	public String toString() {
		return "CertificateMemberDTO [idNo=" + idNo + ", memberNo=" + memberNo + ", memberName=" + memberName
				+ ", jobName=" + jobName + ", departmentName=" + departmentName + ", memberId=" + memberId
				+ ", hireDate=" + hireDate + ", accSecessionDatetime=" + accSecessionDatetime + "]";
	}

}

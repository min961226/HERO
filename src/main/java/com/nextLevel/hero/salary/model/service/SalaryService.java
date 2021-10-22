package com.nextLevel.hero.salary.model.service;

import java.util.List;

import com.nextLevel.hero.mngSalary.model.dto.DetailPayDTO;
import com.nextLevel.hero.salary.model.dto.BankListDTO;
import com.nextLevel.hero.salary.model.dto.MyAccountDTO;
import com.nextLevel.hero.salary.model.dto.SalaryDTO;

public interface SalaryService {

	List<MyAccountDTO> selectAccountList(int companyNo, int idNo);

	List<BankListDTO> selectBankList();

	List<SalaryDTO> selectMyPaymentList(SalaryDTO search);

	List<DetailPayDTO> selectDetailList(SalaryDTO search);

	String applyAccount(MyAccountDTO add);

}

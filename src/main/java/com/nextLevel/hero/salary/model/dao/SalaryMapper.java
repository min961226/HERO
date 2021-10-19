package com.nextLevel.hero.salary.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mngSalary.model.dto.DetailPayDTO;
import com.nextLevel.hero.salary.model.dto.BankListDTO;
import com.nextLevel.hero.salary.model.dto.MyAccountDTO;
import com.nextLevel.hero.salary.model.dto.SalaryDTO;

@Mapper
public interface SalaryMapper {

	List<MyAccountDTO> selectAccountList(int companyNo, int idNo);

	List<BankListDTO> selectBankList();

	List<SalaryDTO> selectMyPaymentList(SalaryDTO search);

	List<DetailPayDTO> listPayDetail(SalaryDTO search);

	List<DetailPayDTO> listDeductDetail(SalaryDTO search);

}

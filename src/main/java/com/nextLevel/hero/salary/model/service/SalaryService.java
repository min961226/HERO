package com.nextLevel.hero.salary.model.service;

import java.util.List;

import com.nextLevel.hero.salary.model.dto.MyAccountDTO;

public interface SalaryService {

	List<MyAccountDTO> selectAccountList(int companyNo, int idNo);

}

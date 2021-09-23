package com.nextLevel.hero.mngSalary.model.service;

import java.util.List;

import com.nextLevel.hero.mngSalary.model.dto.MngDeductFourInsDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngSalaryDTO;

public interface MngSalaryService {

	List<MngSalaryDTO> listMngAnnualSalary();

	List<MngDeductFourInsDTO> listMngFourInsuranceList();


}

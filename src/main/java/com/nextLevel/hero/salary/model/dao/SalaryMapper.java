package com.nextLevel.hero.salary.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.salary.model.dto.MyAccountDTO;

@Mapper
public interface SalaryMapper {

	List<MyAccountDTO> selectAccountList(int companyNo, int idNo);

}

package com.nextLevel.hero.main.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.common.SelectCriteria;
import com.nextLevel.hero.workattitude.model.dto.WorkAttitudeDTO;
import com.nextLevel.hero.workattitude.model.dto.WorkCommuteDTO;

@Mapper
public interface MainMapper {

	int selectMemberCount(Map searchMap, int companyNo, int idNo);

	List<WorkAttitudeDTO> selectMemberList(Map searchMap, int companyNo, int idNo, SelectCriteria selectCriteria);

	List<WorkCommuteDTO> selectWorkAttitudeList(WorkAttitudeDTO memberInfo, String formatedNow, int idNo);

}

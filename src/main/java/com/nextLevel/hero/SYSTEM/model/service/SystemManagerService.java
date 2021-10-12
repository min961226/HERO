package com.nextLevel.hero.SYSTEM.model.service;

import java.util.List;

import com.nextLevel.hero.SYSTEM.model.dto.NewMemberDTO;

public interface SystemManagerService {

	List<String> selectMemberIdList();

	int insertNewMember(NewMemberDTO newMemberDTO);

	List<NewMemberDTO> selectControlClientList();

}

package com.nextLevel.hero.SYSTEM.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.SYSTEM.model.dao.SystemManagerMapper;

@Service("systemManagerService")
public class SystemManagerServiceImpl implements SystemManagerService{

	private final SystemManagerMapper systemManagerMapper; 
	
	@Autowired
	public SystemManagerServiceImpl(SystemManagerMapper systemManagerMapper) {
		this.systemManagerMapper = systemManagerMapper;
	}
	
}

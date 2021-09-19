package com.nextLevel.hero.main.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.main.model.dao.MainMapper;

@Service("mainService")
public class MainServiceImpl implements MainService{

	private final MainMapper mainMapper;
	
	@Autowired
	public MainServiceImpl(MainMapper mainMapper) {
		this.mainMapper = mainMapper;
	}
}

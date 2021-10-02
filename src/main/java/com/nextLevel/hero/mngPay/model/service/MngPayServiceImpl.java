package com.nextLevel.hero.mngPay.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nextLevel.hero.mngPay.model.dao.MngPayMapper;

@Service("mngPayService")
public class MngPayServiceImpl implements MngPayService{

	private final MngPayMapper mngPayMapper;
	
	@Autowired
	public MngPayServiceImpl(MngPayMapper mngPayMapper) {
		this.mngPayMapper = mngPayMapper;
	}
	
	
	
	
	
	
	
}

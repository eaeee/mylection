package com.snks.mylection.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snks.mylection.dao.LectionDAO;
import com.snks.mylection.service.LectionService;

@Service
public class LectionServiceImpl implements LectionService {
	@Autowired
	private LectionDAO lectionsDao;

	@Override
	@Transactional
	public void addDefaultLection() {
		lectionsDao.addDefaultLection();
		
	}

}

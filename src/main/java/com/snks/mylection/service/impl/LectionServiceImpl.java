package com.snks.mylection.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snks.mylection.dao.LectionDAO;
import com.snks.mylection.dao.UserDAO;
import com.snks.mylection.model.Lection;
import com.snks.mylection.model.User;
import com.snks.mylection.service.LectionService;

@Service
@Transactional
public class LectionServiceImpl implements LectionService {
	@Autowired
	private LectionDAO lectionDao;
	
	@Autowired
	private UserDAO userDao;


	@Override
	public void save(Lection lection, String name) {
		User user=  userDao.findUserByName(name);
		lection.setAuthor(user);
		lectionDao.save(lection);
	}

}

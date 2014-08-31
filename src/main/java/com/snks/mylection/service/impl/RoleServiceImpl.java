package com.snks.mylection.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snks.mylection.dao.RoleDAO;
import com.snks.mylection.model.Role;
import com.snks.mylection.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDAO roleDao;

	@Override
	public void save(Role role) {
		roleDao.save(role);
		
	}

}

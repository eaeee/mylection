package com.snks.mylection.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snks.mylection.dao.RoleDAO;
import com.snks.mylection.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {
    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public void save(Role role) {
		sessionFactory.openSession().save(role);

	}

}

package com.snks.mylection.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		sessionFactory.getCurrentSession().save(role);

	}

	@Override
	public Role findByName(String roleName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Role.class);
		criteria.add(Restrictions.eq("roleName", roleName));		
		return (Role) criteria.uniqueResult();
	}

	@Override
	public void init(Role role) {
		sessionFactory.openSession().save(role);
		
	}
}

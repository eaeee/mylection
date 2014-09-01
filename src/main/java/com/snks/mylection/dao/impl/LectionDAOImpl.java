package com.snks.mylection.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snks.mylection.dao.LectionDAO;
import com.snks.mylection.model.Lection;
import com.snks.mylection.model.User;


@Repository
public class LectionDAOImpl implements LectionDAO{
    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public void save(Lection lection) {
		sessionFactory.getCurrentSession().save(lection);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lection> findByUser(User user) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Lection.class);
		criteria.add(Restrictions.eq("lectionAuthor", user));		
		return (List<Lection>) criteria.list();
	}

	@Override
	public void delete(int id) {
		Lection lection = (Lection) sessionFactory.getCurrentSession().get(Lection.class, id);
		sessionFactory.getCurrentSession().delete(lection);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lection> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return (List<Lection>)session.createQuery("from Lection").list();
	}
	

}

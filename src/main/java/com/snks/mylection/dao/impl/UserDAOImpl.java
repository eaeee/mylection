package com.snks.mylection.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snks.mylection.dao.UserDAO;
import com.snks.mylection.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;


	@Override
	public User findUserByName(String userName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", userName));		
		return (User) criteria.uniqueResult();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		Session session = sessionFactory.openSession();
		return (List<User>)session.createQuery("from User").list();
	}

	@Override
	public User findById(int id) {
		Session session = sessionFactory.openSession();
		return (User) session.get(User.class,id);
	}

	@Override
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void delete(int id) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
		sessionFactory.getCurrentSession().delete(user);
		
	}

}

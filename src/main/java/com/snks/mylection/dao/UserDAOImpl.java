package com.snks.mylection.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.snks.mylection.model.User;

public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public void addDefaultUser() {
		User user = new User();
		user.setUserName("Third User");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public User findUserByName(String userName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", userName));		
		return (User) criteria.uniqueResult();
		
	}

}

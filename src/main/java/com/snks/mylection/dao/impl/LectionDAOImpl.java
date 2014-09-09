package com.snks.mylection.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snks.mylection.dao.LectionDAO;
import com.snks.mylection.model.Lection;
import com.snks.mylection.model.Subject;
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

	@Override
	public Lection findByid(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Lection) session.get(Lection.class,id);
	}

	@Override
	public void update(Lection lection) {
		Session session = sessionFactory.getCurrentSession();
		Lection oldLection = (Lection) session.get(Lection.class,lection.getLectionId());
		oldLection.setLectionBody(lection.getLectionBody());
		oldLection.setLectionName(lection.getLectionName());
		oldLection.setLectionDate(lection.getLectionDate());
		sessionFactory.getCurrentSession().update(oldLection);
	}

	
	@Override
	public void delete(Lection lection) {
		sessionFactory.getCurrentSession().delete(lection);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lection> findLast() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Lection.class);
		criteria.setMaxResults(10);
		criteria.addOrder(Order.desc("lectionDate.modifiedDate"));
		return (List<Lection>) criteria.list();
	}

	@Override
	public Lection findByIdWithCourses(int lectionId) {
		Session session = sessionFactory.getCurrentSession();
		session.enableFetchProfile("lection-with-courses");
		return (Lection) session.get(Lection.class,lectionId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lection> search(String word, String wordInBody, Subject subject) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Lection.class);
		criteria.addOrder(Order.desc("lectionDate.modifiedDate"));
		if (subject !=null) {
			criteria.add(Restrictions.eq("lectionSubject", subject));
		}
		if (!word.equals("")) {
			criteria.add(Restrictions.like("lectionName", word, MatchMode.ANYWHERE));
		}
		if (!wordInBody.equals("")) {
			criteria.add(Restrictions.like("lectionBody", wordInBody, MatchMode.ANYWHERE));
		}
		return (List<Lection>)criteria.list();
	}
	

}

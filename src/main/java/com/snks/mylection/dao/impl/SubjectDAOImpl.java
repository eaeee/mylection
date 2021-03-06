package com.snks.mylection.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snks.mylection.dao.SubjectDAO;
import com.snks.mylection.model.Subject;
import com.snks.mylection.model.SubjectClassification;

@Repository
public class SubjectDAOImpl implements SubjectDAO {
    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public void addSubject(Subject subject) {
		sessionFactory.getCurrentSession().save(subject);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return (List<Subject>)session.createQuery("from Subject").list();
	}

	@Override
	  public void delete(int id) {
	    Subject subject = (Subject) sessionFactory.getCurrentSession().get(Subject.class, id);
	    sessionFactory.getCurrentSession().delete(subject);
	    
	  }

	@Override
	public void save(Subject subject) {
		sessionFactory.getCurrentSession().save(subject);
		
	}

	@Override
	public Subject findByName(String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Subject.class);
		criteria.add(Restrictions.eq("subjectName",name));
		return (Subject)criteria.uniqueResult();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> findByClass(SubjectClassification classification) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Subject.class);
		criteria.add(Restrictions.eq("classification",classification));
		return (List<Subject>)criteria.list();
	}
}

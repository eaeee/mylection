package com.snks.mylection.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snks.mylection.dao.SubjectClassificationDAO;
import com.snks.mylection.model.SubjectClassification;

@Repository
public class SubjectClassificationDAOImpl implements SubjectClassificationDAO {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void addClassification(SubjectClassification classification) {
      sessionFactory.getCurrentSession().save(classification);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SubjectClassification> findAll() {
      Session session = sessionFactory.getCurrentSession();
      return (List<SubjectClassification>)session.createQuery("from SubjectClassification").list();
    }

    @Override
    public void delete(int id) {
      SubjectClassification classification = (SubjectClassification) sessionFactory.getCurrentSession().get(SubjectClassification.class, id);
      sessionFactory.getCurrentSession().delete(classification);
      
    }

	@Override
	public void save(SubjectClassification classification) {
		sessionFactory.getCurrentSession().save(classification);
		
	}

	@Override
	public SubjectClassification findByName(String subjectClassificationName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SubjectClassification.class);
		criteria.add(Restrictions.eq("subjectClassificationName",subjectClassificationName));
		return (SubjectClassification)criteria.uniqueResult();
	}
}

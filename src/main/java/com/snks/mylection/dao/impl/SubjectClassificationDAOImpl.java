package com.snks.mylection.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
      Session session = sessionFactory.openSession();
      return (List<SubjectClassification>)session.createQuery("from SubjectClassification").list();
    }

}

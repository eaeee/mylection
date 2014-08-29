package com.snks.mylection.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snks.mylection.dao.SubjectDAO;

@Repository
public class SubjectDAOImpl implements SubjectDAO {
    @Autowired
    private SessionFactory sessionFactory;

}

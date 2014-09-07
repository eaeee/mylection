package com.snks.mylection.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snks.mylection.dao.CourseDAO;
import com.snks.mylection.model.Course;

@Repository
public class CourseDAOImpl implements CourseDAO{
    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public void add(Course course) {
		sessionFactory.getCurrentSession().save(course);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> findAll() {
		return (List<Course>)sessionFactory.getCurrentSession().createQuery("from Course").list();
	}

}

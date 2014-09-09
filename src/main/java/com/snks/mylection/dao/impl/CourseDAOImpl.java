package com.snks.mylection.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snks.mylection.dao.CourseDAO;
import com.snks.mylection.model.Course;
import com.snks.mylection.model.User;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> findByUser(User user) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Course.class);
		criteria.add(Restrictions.eq("courseAuthor", user));		
		return (List<Course>) criteria.list();
	}

	@Override
	public Course findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Course) session.get(Course.class,id);
	}

	@Override
	public void update(Course course) {
		sessionFactory.getCurrentSession().update(course);	
	}

	@Override
	public Course findByIdWithLections(int courseId) {
		Session session = sessionFactory.getCurrentSession();
		session.enableFetchProfile("course-with-lections");
		return (Course) session.get(Course.class,courseId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> search(String word) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Course.class);
		if (!word.equals("")) {
			criteria.add(Restrictions.like("courseName", word, MatchMode.ANYWHERE));
		}
		return (List<Course>)criteria.list();
	}

	@Override
	public Course findByIdWithFollowers(int courseId) {
		Session session = sessionFactory.getCurrentSession();
		session.enableFetchProfile("course-with-followers");
		return (Course) session.get(Course.class,courseId);
	}


}

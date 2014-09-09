package com.snks.mylection.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snks.mylection.dao.CourseDAO;
import com.snks.mylection.dao.LectionDAO;
import com.snks.mylection.dao.UserDAO;
import com.snks.mylection.model.Course;
import com.snks.mylection.model.User;
import com.snks.mylection.service.CourseService;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDAO courseDao;
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private LectionDAO lectionDAO;

	@Override
	public void add(Course course) {
		courseDao.add(course);
		
	}

	@Override
	public List<Course> findAll() {
		return courseDao.findAll();
	}

	@Override
	public List<Course> findByUserName(String userName) {
		User user = userDao.findUserByName(userName);
		return courseDao.findByUser(user);
	}

	@Override
	public Course findById(int id) {
		return courseDao.findById(id);
	}

	@Override
	public void update(Course course) {
		courseDao.update(course);
		
	}

	@Override
	public Course findByIdWithLections(int courseId) {
		return courseDao.findByIdWithLections(courseId);
	}

	@Override
	public List<Course> search(String word) {
		return courseDao.search(word);
	}

	@Override
	public Course findByIdWithFollowers(int courseId) {
		return courseDao.findByIdWithFollowers(courseId);
	}

}

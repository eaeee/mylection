package com.snks.mylection.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snks.mylection.dao.CourseDAO;
import com.snks.mylection.model.Course;
import com.snks.mylection.service.CourseService;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDAO courseDao;

	@Override
	public void add(Course course) {
		courseDao.add(course);
		
	}

	@Override
	public List<Course> findAll() {
		return courseDao.findAll();
	}

}

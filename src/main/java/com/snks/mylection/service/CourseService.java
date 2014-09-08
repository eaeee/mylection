package com.snks.mylection.service;

import java.util.List;

import com.snks.mylection.model.Course;

public interface CourseService {

	void add(Course course);

	List<Course> findAll();

	List<Course> findByUserName(String userName);

	Course findById(int courseId);

	void update(Course course);

	Course findByIdWithLections(int courseId);

}

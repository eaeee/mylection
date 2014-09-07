package com.snks.mylection.dao;

import java.util.List;

import com.snks.mylection.model.Course;

public interface CourseDAO {

	void add(Course course);

	List<Course> findAll();

}

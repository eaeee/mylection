package com.snks.mylection.dao;

import java.util.List;

import com.snks.mylection.model.Course;
import com.snks.mylection.model.User;

public interface CourseDAO {

	void add(Course course);

	List<Course> findAll();

	List<Course> findByUser(User user);

	Course findById(int id);

	void update(Course course);

	Course findByIdWithLections(int courseId);

}

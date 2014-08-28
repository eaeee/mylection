package com.snks.mylection.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="COURSES")
public class Course {
	
	@Id @GeneratedValue
	private int courseId;
	
	@ManyToMany(mappedBy="courses")
	private List<Lection> lections = new ArrayList<Lection>();



	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

}

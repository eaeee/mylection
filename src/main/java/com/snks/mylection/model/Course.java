package com.snks.mylection.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="COURSES")
public class Course {
	
	@Id @GeneratedValue
	private int courseId;
	
	@ManyToMany(mappedBy="courses")
	private List<Lection> lections = new ArrayList<Lection>();
	
	@ManyToOne
	private User courseAuthor;
	
	@ManyToMany
	private List<User> followers =  new ArrayList<User>();
	
	private String courseName;
	
	public List<Lection> getLections() {
		return lections;
	}

	public void setLections(List<Lection> lections) {
		this.lections = lections;
	}

	public User getCourseAuthor() {
		return courseAuthor;
	}

	public void setCourseAuthor(User courseAuthor) {
		this.courseAuthor = courseAuthor;
	}


	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public List<User> getFollowers() {
		return followers;
	}

	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
  
}

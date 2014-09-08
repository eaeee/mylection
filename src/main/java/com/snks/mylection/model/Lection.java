package com.snks.mylection.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;


@Entity
@Table(name="lections")
@FetchProfile(name = "lection-with-courses", fetchOverrides = {
		   @FetchProfile.FetchOverride(entity = Lection.class, association = "courses", mode = FetchMode.JOIN)
		})
public class Lection {
	
	@Id @GeneratedValue
	private int lectionId;
	
	@Size(min=5,message="The name of the lection must be at least 5 characters!")
	private String lectionName;
	
	@Embedded
	private LectionDate lectionDate ;
	
	@ManyToOne
	@JoinColumn(name="AUTHOR_ID")
	private User lectionAuthor;
	
	private int lastModifiedUserId;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="LECTIONS_AND_COURSES",
			joinColumns=@JoinColumn(name="LECTION_ID"),
			inverseJoinColumns=@JoinColumn(name="COURSE_ID"))
	private List<Course> courses = new ArrayList<Course>();
	
	@Lob
	private String lectionBody;
	
	@ManyToOne
	@JoinColumn(name="SUBJECT_ID")
	private Subject lectionSubject;
	
	
	
	
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public User getAuthor() {
		return lectionAuthor;
	}
	public void setAuthor(User author) {
		this.lectionAuthor = author;
	}
	public Subject getSubject() {
		return lectionSubject;
	}
	public void setSubject(Subject subject) {
		this.lectionSubject = subject;
	}
	public int getLastModifiedUserId() {
		return lastModifiedUserId;
	}
	public void setLastModifiedUserId(int lastModifiedUserId) {
		this.lastModifiedUserId = lastModifiedUserId;
	}
	public int getLectionId() {
		return lectionId;
	}
	public void setLectionId(int lectionId) {
		this.lectionId = lectionId;
	}
	public LectionDate getLectionDate() {
		return lectionDate;
	}
	public void setLectionDate(LectionDate lectionDate) {
		this.lectionDate = lectionDate;
	}
	public String getLectionBody() {
		return lectionBody;
	}
	public void setLectionBody(String lectionBody) {
		this.lectionBody = lectionBody;
	}
	public String getLectionName() {
		return lectionName;
	}
	public void setLectionName(String lectionName) {
		this.lectionName = lectionName;
	}
}

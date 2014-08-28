package com.snks.mylection.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="lections")
public class Lection {
	
	@Id @GeneratedValue
	private int lectionId;
	
	@Embedded
	private LectionDate lectionDate ;
	
	private int authorId;
	
	private int lastModifiedUserId;
	
	@ManyToMany
	@JoinTable(name="LECTIONS_AND_COURSES",
			joinColumns=@JoinColumn(name="LECTIO_ID"),
			inverseJoinColumns=@JoinColumn(name="COURSE_ID"))
	private List<Course> courses = new ArrayList<Course>();
	
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	@Lob
	private String lectionBody;
	
	
	
	
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
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

	
}

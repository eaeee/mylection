package com.snks.mylection.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;

import com.snks.mylection.annotation.UniqueUserName;


@Entity
@Table(name="USERS")
@FetchProfile(name = "user-with-subs", fetchOverrides = {
		   @FetchProfile.FetchOverride(entity = User.class, association = "subCourses", mode = FetchMode.JOIN)
		})
public class User {
	@Id @GeneratedValue
	private int userId;
	
	@Size(min=5,message="Name must be at least 5 characters!")
	@Column(unique=true)
	@UniqueUserName(message="This username already exists!")
	private String userName;
	
	@Size(min=8,message="Name must be at least 8 characters!")
	private String userPassword;
	
	@ManyToMany
	@JoinTable(name="USERS_AND_ROLES",
			joinColumns=@JoinColumn(name="USER_ID"),
			inverseJoinColumns=@JoinColumn(name="ROLE_ID"))
	private List<Role> roles = new ArrayList<Role>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USERS_AND_SUBCOURSES",
				joinColumns=@JoinColumn(name="USER_ID"),
				inverseJoinColumns=@JoinColumn(name="COURSE_ID"))
	private List<Course> subCourses = new ArrayList<Course>();
	
	
	
	
	@OneToMany(mappedBy="lectionAuthor")
	private List<Lection> lections = new ArrayList<Lection>();
	
	public List<Lection> getLections() {
		return lections;
	}
	public void setLections(List<Lection> lections) {
		this.lections = lections;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Course> getSubCourses() {
		return subCourses;
	}
	public void setSubCourses(List<Course> subCourses) {
		this.subCourses = subCourses;
	}

	
}